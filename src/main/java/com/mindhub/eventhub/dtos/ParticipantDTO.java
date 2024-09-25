package com.mindhub.eventhub.dtos;

import com.mindhub.eventhub.enums.Gender;
import com.mindhub.eventhub.models.CustomerEvent;
import com.mindhub.eventhub.models.Participant;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ParticipantDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private short age;
    private Gender gender;
    private Set<CustomerEventDTO> customerEvents;

    public ParticipantDTO(UUID id, String firstName, String lastName, String email, short age, Gender gender, Set<CustomerEventDTO> customerEvents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.customerEvents = customerEvents;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public short getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Set<CustomerEventDTO> getCustomerEvents() {
        return customerEvents;
    }
}
