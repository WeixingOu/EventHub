package com.mindhub.eventhub.models;

import com.mindhub.eventhub.enums.Gender;
import com.mindhub.eventhub.enums.Role;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Participant extends Customer{
    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    public Participant() {

    }

    public Participant(String firstName, String lastName, String email, String password, short age, Gender gender, Role role) {
        super(firstName, lastName, email, password, age, gender, role);
    }

    public Set<CustomerEvent> getCustomerEvents() {
        return customerEvents;
    }

    public void addCustomerEvent(CustomerEvent customerEvent) {
        customerEvent.setParticipant(this);
        customerEvents.add(customerEvent);
    }
}
