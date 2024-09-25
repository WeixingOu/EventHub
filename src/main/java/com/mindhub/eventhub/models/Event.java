package com.mindhub.eventhub.models;

import com.mindhub.eventhub.enums.Role;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eventId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private short ageReq;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false)
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Manager manager;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CustomerEvent> participants = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EventLocation> eventLocations = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> ratings = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "event_category",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Event() {
    }

    public Event(String description, String image, short ageReq, String name) {
        this.description = description;
        this.image = image;
        this.ageReq = ageReq;
        this.name = name;
    }

    public UUID getEventId() {
        return eventId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public short getAgeReq() {
        return ageReq;
    }

    public void setAgeReq(short ageReq) {
        this.ageReq = ageReq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<CustomerEvent> getParticipants() {
        return participants;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void addParticipants(CustomerEvent participant) {
        participant.setEvent(this);
        participants.add(participant);
    }

    public void addEventLocation(EventLocation eventLocation) {
        eventLocation.setEvent(this);
        eventLocations.add(eventLocation);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setEvent(this);
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
        rating.setEvent(this);
    }

    public void addCategories(Category category) {
        categories.add(category);
        category.getEvents().add(this);
    }
}
