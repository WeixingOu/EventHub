package com.mindhub.eventhub.models;

import com.mindhub.eventhub.enums.Gender;
import com.mindhub.eventhub.enums.Role;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Manager extends Customer{
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Event> events = new HashSet<>();

    public Manager() {

    }

    public Manager(String firstName, String lastName, String email, String password, short age, Gender gender, Role role) {
        super(firstName, lastName, email, password, age, gender, role);
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        event.setManager(this);
        events.add(event);
    }
}
