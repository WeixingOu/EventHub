package com.mindhub.eventhub.services;

import com.mindhub.eventhub.dtos.ParticipantCreateDTO;
import com.mindhub.eventhub.dtos.ParticipantDTO;

public interface ParticipantService {
    ParticipantDTO createParticpant(ParticipantCreateDTO participantCreateDTO);

    ParticipantDTO getParticipantByEmail(String email);
}
