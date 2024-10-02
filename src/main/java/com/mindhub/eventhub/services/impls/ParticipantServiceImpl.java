package com.mindhub.eventhub.services.impls;

import com.mindhub.eventhub.dtos.EventAttendDTO;
import com.mindhub.eventhub.dtos.records.ParticipantCreateDTO;
import com.mindhub.eventhub.dtos.ParticipantDTO;
import com.mindhub.eventhub.enums.Role;
import com.mindhub.eventhub.mappers.CustomerEventMapper;
import com.mindhub.eventhub.mappers.EventAttendMapper;
import com.mindhub.eventhub.mappers.ParticipantMapper;
import com.mindhub.eventhub.models.CustomerEvent;
import com.mindhub.eventhub.models.Event;
import com.mindhub.eventhub.models.Participant;
import com.mindhub.eventhub.repositories.CustomerEventRepository;
import com.mindhub.eventhub.repositories.EventAttendRepository;
import com.mindhub.eventhub.repositories.EventRepository;
import com.mindhub.eventhub.repositories.ParticipantRepository;
import com.mindhub.eventhub.services.AuthenticationFacade;
import com.mindhub.eventhub.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private ParticipantMapper participantMapper;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CustomerEventRepository customerEventRepository;
    @Autowired
    private EventAttendRepository eventAttendRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private CustomerEventMapper customerEventMapper;
    @Autowired
    private EventAttendMapper eventAttendMapper;

    @Override
    public ParticipantDTO createParticpant(ParticipantCreateDTO participantCreateDTO) {
        participantRepository.findByEmail(participantCreateDTO.email())
            .orElseThrow(() -> new RuntimeException("Participant email already registered: " + participantCreateDTO.email()));

        Participant participant = new Participant(participantCreateDTO.firstName(), participantCreateDTO.lastName(), participantCreateDTO.email(), passwordEncoder.encode(participantCreateDTO.password()), participantCreateDTO.age(), participantCreateDTO.gender(), Role.PARTICIPANT);
        Participant savedParticipant = participantRepository.save(participant);
        return participantMapper.toParticipantDTO(savedParticipant);
    }

    @Override
    public ParticipantDTO getParticipantByEmail(String email) {
        return participantMapper.toParticipantDTO(participantRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Participant not found with email: " + email)));
    }

    @Override
    public void registerEvent(UUID eventId) {
        Participant participant = participantRepository.findByEmail(authenticationFacade.getAuthentication().getName()).
            orElseThrow(() -> new RuntimeException("Participant not found with email: " + authenticationFacade.getAuthentication().getName()));

        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        customerEventRepository.findByEventAndParticipant(event, participant).ifPresent(
            existCustomerEvent -> {
                throw new RuntimeException("Event with ID " + event.getEventId() + " is already registered for participant with email " + participant.getEmail());
            }
        );

        CustomerEvent customerEvent = new CustomerEvent();

        participant.addCustomerEvent(customerEvent);

        event.addParticipants(customerEvent);

        customerEvent = customerEventRepository.save(customerEvent);
    }

    @Override
    public List<EventAttendDTO> getEventAttends() {
        Participant participant = participantRepository.findByEmail(authenticationFacade.getAuthentication().getName()).
            orElseThrow(() -> new RuntimeException("Participant not found with email: " + authenticationFacade.getAuthentication().getName()));

        return customerEventRepository.findByParticipant(participant).stream()
            .flatMap(customerEvent -> eventAttendRepository.findByCustomerEvent(customerEvent).stream()
                .map(eventAttendMapper::toEventAttendDTO))
            .collect(Collectors.toList());
    }
}
