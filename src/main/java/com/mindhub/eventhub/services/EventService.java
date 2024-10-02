package com.mindhub.eventhub.services;

import com.mindhub.eventhub.dtos.records.EventCreateDTO;
import com.mindhub.eventhub.dtos.EventDTO;
import com.mindhub.eventhub.dtos.records.EventLocationCreateDTO;
import com.mindhub.eventhub.dtos.EventLocationDTO;
import com.mindhub.eventhub.dtos.EventAttendDTO;

import java.util.List;
import java.util.UUID;

public interface EventService {
    List<EventDTO> getAllEvents();

    EventDTO createEvent(EventCreateDTO eventCreateDTO);

    EventLocationDTO createEventLocation(EventLocationCreateDTO eventLocationCreateDTO);

    void cancelEvent(UUID eventId);

    void cancelEventLocation(UUID eventLocationId);

    List<EventDTO> getEventsByManager();

    EventAttendDTO registerAttend(UUID eventId, UUID participantId, UUID eventLocationId);
}
