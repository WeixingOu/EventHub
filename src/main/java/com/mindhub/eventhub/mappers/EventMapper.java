package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.EventDTO;
import com.mindhub.eventhub.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ManagerMapper.class })
public interface EventMapper {
    EventDTO toEventDTO(Event event);
}
