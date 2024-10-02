package com.mindhub.eventhub.services.impls;

import com.mindhub.eventhub.dtos.*;
import com.mindhub.eventhub.dtos.records.EventCreateDTO;
import com.mindhub.eventhub.dtos.records.EventLocationCreateDTO;
import com.mindhub.eventhub.mappers.EventAttendMapper;
import com.mindhub.eventhub.mappers.EventLocationMapper;
import com.mindhub.eventhub.mappers.EventMapper;
import com.mindhub.eventhub.models.*;
import com.mindhub.eventhub.repositories.*;
import com.mindhub.eventhub.services.AuthenticationFacade;
import com.mindhub.eventhub.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EventSeviceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventLocationRepository eventLocationRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomerEventRepository customerEventRepository;
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private EventAttendRepository eventAttendRepository;
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private EventLocationMapper eventLocationMapper;
    @Autowired
    private EventAttendMapper eventAttendMapper;

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findByActiveTrue().stream()
            .map(eventMapper::toEventDTO)
            .toList();
    }

    @Override
    public EventDTO createEvent(EventCreateDTO eventCreateDTO) {
        Manager manager = managerRepository.findByEmail(authenticationFacade.getAuthentication().getName())
            .orElseThrow(() -> new RuntimeException("Manager not found with email: " + authenticationFacade.getAuthentication().getName()));

        Event event = new Event(eventCreateDTO.description(), eventCreateDTO.image(), eventCreateDTO.ageReq(), eventCreateDTO.name());

        manager.addEvent(event);

        event = eventRepository.save(event);

        eventCreateDTO.categoryIds().stream()
            .map(categoryId -> categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId)))
                .forEach(event::addCategories);

        event = eventRepository.save(event);

        return eventMapper.toEventDTO(event);
    }

    @Override
    public EventLocationDTO createEventLocation(EventLocationCreateDTO eventLocationCreateDTO) {
        Event event = eventRepository.findById(eventLocationCreateDTO.eventId())
            .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventLocationCreateDTO.eventId()));

        Location location = locationRepository.findById(eventLocationCreateDTO.locationId())
            .orElseThrow(() -> new RuntimeException("Location not found with id: " + eventLocationCreateDTO.locationId()));

        eventLocationRepository.findByLocationLocationIdAndEventDate(eventLocationCreateDTO.locationId(), eventLocationCreateDTO.eventDate())
            .ifPresent(existEventLocation -> {
                throw new RuntimeException("Location with ID " + eventLocationCreateDTO.locationId() + " is already booked for the date " + eventLocationCreateDTO.eventDate());
            });

        EventLocation eventLocation = new EventLocation(eventLocationCreateDTO.eventDate(), eventLocationCreateDTO.capacity());

        event.addEventLocation(eventLocation);

        location.addEventLocation(eventLocation);

        eventLocation = eventLocationRepository.save(eventLocation);

        return eventLocationMapper.toEventLocationDTO(eventLocation);
    }

    @Override
    public void cancelEvent(UUID eventId) {
        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        event.setActive(false);

        event.getEventLocations().forEach(eventLocation -> {
            eventLocation.setActive(false);
            eventLocationRepository.save(eventLocation);
        });

        eventRepository.save(event);
    }

    @Override
    public void cancelEventLocation(UUID eventLocationId) {
        EventLocation eventLocation = eventLocationRepository.findById(eventLocationId)
            .orElseThrow(() -> new RuntimeException("Event location not found with id: " + eventLocationId));

        eventLocation.setActive(false);

        eventLocationRepository.save(eventLocation);
    }

    @Override
    public List<EventDTO> getEventsByManager() {
        Manager manager = managerRepository.findByEmail(authenticationFacade.getAuthentication().getName())
            .orElseThrow(() -> new RuntimeException("Manager not found with email: " + authenticationFacade.getAuthentication().getName()));

        return eventRepository.findByManager(manager).stream()
            .map(eventMapper::toEventDTO)
            .toList();
    }

    @Override
    public EventAttendDTO registerAttend(UUID eventId, UUID participantId, UUID eventLocationId) {
        Participant participant = participantRepository.findById(participantId).
            orElseThrow(() -> new RuntimeException("Participant not found with email: " + authenticationFacade.getAuthentication().getName()));

        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        CustomerEvent customerEvent = customerEventRepository.findByEventAndParticipant(event, participant)
            .orElseThrow(() -> new RuntimeException("Participant with id: " + participantId + "is not registered for event with id: " + eventId));

        EventLocation eventLocation = eventLocationRepository.findById(eventLocationId)
            .orElseThrow(() -> new RuntimeException("Event location not found with id: " + eventLocationId));

        EventAttend eventAttend = new EventAttend(customerEvent, eventLocation, true);

        eventAttend = eventAttendRepository.save(eventAttend);

        return eventAttendMapper.toEventAttendDTO(eventAttend);
    }
}
