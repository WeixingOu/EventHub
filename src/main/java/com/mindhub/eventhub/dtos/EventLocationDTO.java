package com.mindhub.eventhub.dtos;

import java.time.LocalDate;
import java.util.UUID;

public class EventLocationDTO {
    private UUID eventLocationId;
    private LocalDate eventDate;
    private int capacity;
    private LocationDTO locationDTO;

    public EventLocationDTO(UUID eventLocationId, LocalDate eventDate, int capacity, LocationDTO locationDTO) {
        this.eventLocationId = eventLocationId;
        this.eventDate = eventDate;
        this.capacity = capacity;
        this.locationDTO = locationDTO;
    }

    public UUID getEventLocationId() {
        return eventLocationId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public LocationDTO getLocationDTO() {
        return locationDTO;
    }
}
