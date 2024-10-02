package com.mindhub.eventhub.dtos.records;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record RatingCreateDTO(
    @Min(1)
    @Max(10)
    int score
) {
}
