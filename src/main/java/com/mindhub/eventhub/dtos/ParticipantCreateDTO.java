package com.mindhub.eventhub.dtos;

import com.mindhub.eventhub.enums.Gender;
import com.mindhub.eventhub.validations.annotations.EmailUnique;
import com.mindhub.eventhub.validations.annotations.Password;
import jakarta.validation.constraints.*;

public record ParticipantCreateDTO(
    @NotBlank
    @Size(min = 3, max = 50)
        String firstName,
    @NotBlank
    @Size(min = 3, max = 50)
    String lastName,
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 15, message = "Password must be at least 8 characters long")
    @Password(message = "Password must be 8-15 characters, contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    String password,
    @NotBlank
    @Email @EmailUnique
    String email,
    @Min(value = 16)
    short age,
    @NotNull
    Gender gender
) {
}
