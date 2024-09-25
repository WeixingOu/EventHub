package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.CustomerCommentDTO;
import com.mindhub.eventhub.models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerCommentMapper {
    CustomerCommentDTO toCustomerDTO(Customer customer);
}
