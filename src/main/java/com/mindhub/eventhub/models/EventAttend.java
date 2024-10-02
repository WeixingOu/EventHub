package com.mindhub.eventhub.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class EventAttend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventAttendId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerEventId", nullable = false)
    private CustomerEvent customerEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventLocationId", nullable = false)
    private EventLocation eventLocation;

    private boolean attended = false;

    public EventAttend() {
    }

    public EventAttend(CustomerEvent customerEvent, EventLocation eventLocation, boolean attended) {
        this.customerEvent = customerEvent;
        this.eventLocation = eventLocation;
        this.attended = attended;
    }

    public Long getEventAttendId() {
        return eventAttendId;
    }

    public CustomerEvent getCustomerEvent() {
        return customerEvent;
    }

    public void setCustomerEvent(CustomerEvent customerEvent) {
        this.customerEvent = customerEvent;
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
