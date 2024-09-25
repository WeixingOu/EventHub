package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.ManagerDTO;
import com.mindhub.eventhub.models.Customer;
import com.mindhub.eventhub.models.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerDTO toManagerDTO(Manager manager);
}
