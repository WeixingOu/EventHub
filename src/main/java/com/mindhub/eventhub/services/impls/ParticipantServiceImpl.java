package com.mindhub.eventhub.services.impls;

import com.mindhub.eventhub.dtos.ParticipantCreateDTO;
import com.mindhub.eventhub.dtos.ParticipantDTO;
import com.mindhub.eventhub.enums.Role;
import com.mindhub.eventhub.mappers.ParticipantMapper;
import com.mindhub.eventhub.models.Participant;
import com.mindhub.eventhub.repositories.ParticipantRepository;
import com.mindhub.eventhub.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private ParticipantMapper participantMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ParticipantDTO createParticpant(ParticipantCreateDTO participantCreateDTO) {
        Participant participant = new Participant(participantCreateDTO.firstName(), participantCreateDTO.lastName(), participantCreateDTO.email(), passwordEncoder.encode(participantCreateDTO.password()), participantCreateDTO.age(), participantCreateDTO.gender(), Role.PARTICIPANT);
        Participant savedParticipant = participantRepository.save(participant);
        return participantMapper.toParticipantDTO(savedParticipant);
    }

    @Override
    public ParticipantDTO getParticipantByEmail(String email) {
        return participantMapper.toParticipantDTO(participantRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Participant not found with email: " + email)));
    }
}
