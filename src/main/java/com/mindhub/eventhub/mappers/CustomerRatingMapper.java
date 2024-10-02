package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.CustomerRatingDTO;
import com.mindhub.eventhub.models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRatingMapper {
    CustomerRatingDTO toCustomerDTO(Customer customer);
}
