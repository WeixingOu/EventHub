package com.mindhub.eventhub.dtos;

import com.mindhub.eventhub.dtos.CustomerEventDTO;
import com.mindhub.eventhub.dtos.EventLocationDTO;
import com.mindhub.eventhub.models.CustomerEvent;
import com.mindhub.eventhub.models.EventLocation;

public class EventAttendDTO {
    private Long eventAttendId;
    private CustomerEventDTO customerEvent;
    private EventLocationDTO eventLocation;
    private boolean attended;

    public EventAttendDTO(Long eventAttendId, CustomerEventDTO customerEvent, EventLocationDTO eventLocation, boolean attended) {
        this.eventAttendId = eventAttendId;
        this.customerEvent = customerEvent;
        this.eventLocation = eventLocation;
        this.attended = attended;
    }

    public Long getEventAttendId() {
        return eventAttendId;
    }

    public CustomerEventDTO getCustomerEvent() {
        return customerEvent;
    }

    public EventLocationDTO getEventLocation() {
        return eventLocation;
    }

    public boolean isAttended() {
        return attended;
    }
}
