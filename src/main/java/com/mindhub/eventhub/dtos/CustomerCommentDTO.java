package com.mindhub.eventhub.dtos;

import com.mindhub.eventhub.enums.Gender;

import java.util.UUID;

public class CustomerCommentDTO {
    private String firstName;
    private String lastName;

    public CustomerCommentDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
