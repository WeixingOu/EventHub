package com.mindhub.eventhub.validations.validators;

import com.mindhub.eventhub.repositories.CustomerRepository;
import com.mindhub.eventhub.validations.annotations.EmailUnique;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !customerRepository.existsByEmail(email);
    }
}
