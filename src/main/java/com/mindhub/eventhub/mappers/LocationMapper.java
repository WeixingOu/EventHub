package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.LocationDTO;
import com.mindhub.eventhub.models.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toLocationDTO(Location location);
}
