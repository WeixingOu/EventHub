package com.mindhub.eventhub.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class EventLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eventLocationId;

    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false)
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public EventLocation() {

    }

    public EventLocation(LocalDate eventDate, int capacity) {
        this.eventDate = eventDate;
        this.capacity = capacity;
    }

    public UUID getEventLocationId() {
        return eventLocationId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
