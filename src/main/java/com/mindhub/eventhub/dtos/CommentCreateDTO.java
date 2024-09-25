package com.mindhub.eventhub.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CommentCreateDTO(
    @NotBlank
    @Size(min = 5, max = 255, message = "Comment must be between 5 and 255 characters")
    String comment
) {
}
