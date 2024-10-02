package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.models.EventAttend;
import com.mindhub.eventhub.dtos.EventAttendDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerEventMapper.class, EventLocationMapper.class})
public interface EventAttendMapper {
    EventAttendDTO toEventAttendDTO(EventAttend eventAttend);
}
