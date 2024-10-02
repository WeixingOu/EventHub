package com.mindhub.eventhub.dtos;

import java.util.UUID;

public class CustomerEventDTO {
    private UUID customerEventId;
    private EventDTO eventDTO;

    public CustomerEventDTO(UUID customerEventId, ParticipantDTO participantDTO, EventDTO eventDTO) {
        this.customerEventId = customerEventId;
        this.eventDTO = eventDTO;
    }

    public UUID getCustomerEventId() {
        return customerEventId;
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }
}
