package com.mindhub.eventhub.services;

import com.mindhub.eventhub.dtos.records.RatingCreateDTO;
import com.mindhub.eventhub.dtos.RatingDTO;

public interface RatingService {
    RatingDTO createRating(String eventId, RatingCreateDTO ratingCreateDTO);
}
