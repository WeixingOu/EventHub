package com.mindhub.eventhub.dtos;

import com.mindhub.eventhub.models.Customer;

import java.util.UUID;

public class RatingDTO {
    private UUID id;
    private int score;
    private CustomerRatingDTO customerRatingDTO;

    public RatingDTO(UUID id, int score, CustomerRatingDTO customerRatingDTO) {
        this.id = id;
        this.score = score;
        this.customerRatingDTO = customerRatingDTO;
    }

    public UUID getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public CustomerRatingDTO getCustomerRatingDTO() {
        return customerRatingDTO;
    }
}
