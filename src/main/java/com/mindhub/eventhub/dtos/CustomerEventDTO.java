package com.mindhub.eventhub.dtos;

import java.util.UUID;

public class CustomerEventDTO {
    private UUID customerEventId;
    private boolean attended;
    private EventDTO eventDTO;

    public CustomerEventDTO(UUID customerEventId, boolean attended, ParticipantDTO participantDTO, EventDTO eventDTO) {
        this.customerEventId = customerEventId;
        this.attended = attended;
        this.eventDTO = eventDTO;
    }

    public UUID getCustomerEventId() {
        return customerEventId;
    }

    public boolean isAttended() {
        return attended;
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }
}
