package com.mindhub.eventhub.services;

import com.mindhub.eventhub.dtos.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> getAllEvents();
}
