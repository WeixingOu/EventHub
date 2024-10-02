package com.mindhub.eventhub.dtos.records;

import jakarta.validation.constraints.Email;

public record LoginRequestDTO(
    @Email
    String email,
    String password
) {
}
