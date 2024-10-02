package com.mindhub.eventhub.dtos.records;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record EventLocationCreateDTO(
    @NotNull
    UUID locationId,
    @NotNull
    UUID eventId,
    @NotNull
    @Future
    LocalDate eventDate,
    @NotNull
    @Min(50)
    int capacity
) {
}
