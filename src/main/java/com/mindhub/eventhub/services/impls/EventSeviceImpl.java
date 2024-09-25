package com.mindhub.eventhub.services.impls;

import com.mindhub.eventhub.dtos.EventDTO;
import com.mindhub.eventhub.mappers.EventMapper;
import com.mindhub.eventhub.repositories.EventRepository;
import com.mindhub.eventhub.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventSeviceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findByActiveTrue().stream()
            .map(eventMapper::toEventDTO)
            .toList();
    }
}
