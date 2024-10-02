package com.mindhub.eventhub.dtos;

public class CustomerRatingDTO {
    private String firstName;
    private String lastName;

    public CustomerRatingDTO(String firstName, String lastName) {
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
