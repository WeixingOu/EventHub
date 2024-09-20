package com.mindhub.eventhub.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID locationId;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 500)
    private String image;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EventLocation> eventLocations = new HashSet<>();

    public Location() {

    }

    public Location(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void addEventLocation(EventLocation eventLocation) {
        eventLocation.setLocation(this);
        eventLocations.add(eventLocation);
    }
}
