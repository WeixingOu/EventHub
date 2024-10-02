package com.mindhub.eventhub.dtos;


import java.util.List;
import java.util.Set;
import java.util.UUID;

public class EventDTO {
    private UUID eventId;
    private String description;
    private String image;
    private short ageReq;
    private String name;
    private ManagerDTO manager;
    private boolean active = true;

    public EventDTO(UUID eventId, String description, String image, short ageReq, String name, ManagerDTO manager, boolean active) {
        this.eventId = eventId;
        this.description = description;
        this.image = image;
        this.ageReq = ageReq;
        this.name = name;
        this.manager = manager;
        this.active = active;
    }

    public UUID getEventId() {
        return eventId;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public short getAgeReq() {
        return ageReq;
    }

    public String getName() {
        return name;
    }

    public ManagerDTO getManager() {
        return manager;
    }

    public boolean isActive() {
        return active;
    }
}
