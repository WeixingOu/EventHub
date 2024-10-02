package com.mindhub.eventhub.dtos;

import java.util.UUID;

public class LocationDTO {
    private UUID locationId;
    private String name;
    private String image;

    public LocationDTO(UUID locationId, String name, String image) {
        this.locationId = locationId;
        this.name = name;
        this.image = image;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
