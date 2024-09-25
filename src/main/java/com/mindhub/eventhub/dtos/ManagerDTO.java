package com.mindhub.eventhub.dtos;

import com.mindhub.eventhub.enums.Gender;
import com.mindhub.eventhub.models.Manager;

import java.util.UUID;

public class ManagerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private short age;
    private Gender gender;

    public ManagerDTO(UUID id, String firstName, String lastName, String email, short age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
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
}
