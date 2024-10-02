package com.mindhub.eventhub.dtos.records;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record EventCreateDTO(
    @NotBlank
    @Size(min = 10)
    String description,
    @NotBlank
    @Size(min = 10, max = 150)
    String name,
    @NotNull
    @Positive
    short ageReq,
    @NotNull
    List<Long> categoryIds,
    @NotBlank
    String image
) {
}
