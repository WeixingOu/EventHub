package com.mindhub.eventhub.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CustomerEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customerEventId;

    @Column(nullable = false)
    private boolean attended;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Participant participant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    public CustomerEvent() {
    }

    public CustomerEvent(boolean attended) {
        this.attended = attended;
    }

    public UUID getCustomerEventId() {
        return customerEventId;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
