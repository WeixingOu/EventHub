package com.mindhub.eventhub.services;

import com.mindhub.eventhub.dtos.EventAttendDTO;
import com.mindhub.eventhub.dtos.records.ParticipantCreateDTO;
import com.mindhub.eventhub.dtos.ParticipantDTO;

import java.util.List;
import java.util.UUID;

public interface ParticipantService {
    ParticipantDTO createParticpant(ParticipantCreateDTO participantCreateDTO);

    ParticipantDTO getParticipantByEmail(String email);

    void registerEvent(UUID eventId);

    List<EventAttendDTO> getEventAttends();
}
