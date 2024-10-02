package com.mindhub.eventhub.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Event> events = new HashSet<>();

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public Set<Event> getEvents() {
        return events;
    }

}
