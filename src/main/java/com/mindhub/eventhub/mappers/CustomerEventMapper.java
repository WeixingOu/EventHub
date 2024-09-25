package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.CustomerEventDTO;
import com.mindhub.eventhub.models.CustomerEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ParticipantMapper.class, EventMapper.class})
public interface CustomerEventMapper {
    @Mapping(source = "event", target = "eventDTO")
    @Mapping(target = "participantDTO", ignore = true)
    CustomerEventDTO toCustomerEventDTO(CustomerEvent customerEvent);
}
