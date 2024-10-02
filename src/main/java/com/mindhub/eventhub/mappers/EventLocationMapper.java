package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.EventLocationDTO;
import com.mindhub.eventhub.models.EventLocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface EventLocationMapper {
    @Mapping(source = "location", target = "locationDTO")
    EventLocationDTO toEventLocationDTO(EventLocation eventLocation);
}
