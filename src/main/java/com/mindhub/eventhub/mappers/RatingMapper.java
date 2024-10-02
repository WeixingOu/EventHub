package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.CustomerRatingDTO;
import com.mindhub.eventhub.dtos.RatingDTO;
import com.mindhub.eventhub.models.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerRatingDTO.class})
public interface RatingMapper {
    @Mapping(source = "customer", target = "customerRatingDTO")
    RatingDTO toRatingDTO(Rating rating);
}
