package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.ParticipantDTO;
import com.mindhub.eventhub.models.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerEventMapper.class})
public interface ParticipantMapper {
    @Mapping(source = "customerEvents", target = "customerEvents")
    ParticipantDTO toParticipantDTO(Participant participant);
}
