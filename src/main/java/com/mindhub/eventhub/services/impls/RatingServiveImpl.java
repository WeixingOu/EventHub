package com.mindhub.eventhub.services.impls;

import com.mindhub.eventhub.dtos.records.RatingCreateDTO;
import com.mindhub.eventhub.dtos.RatingDTO;
import com.mindhub.eventhub.mappers.RatingMapper;
import com.mindhub.eventhub.models.Customer;
import com.mindhub.eventhub.models.Event;
import com.mindhub.eventhub.models.Rating;
import com.mindhub.eventhub.repositories.CustomerRepository;
import com.mindhub.eventhub.repositories.EventRepository;
import com.mindhub.eventhub.repositories.RatingRepository;
import com.mindhub.eventhub.services.AuthenticationFacade;
import com.mindhub.eventhub.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class RatingServiveImpl implements RatingService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private RatingMapper ratingMapper;

    @Override
    public RatingDTO createRating(String eventId, RatingCreateDTO ratingCreateDTO) {
        Customer customer = customerRepository.findByEmail(authenticationFacade.getAuthentication().getName())
            .orElseThrow(() -> new RuntimeException("Customer not found woth email: " + authenticationFacade.getAuthentication().getName()));

        Event event = eventRepository.findById(UUID.fromString(eventId))
            .orElseThrow(() -> new RuntimeException("Event not found woth id: " + eventId));

        Rating rating = new Rating(ratingCreateDTO.score());

        customer.addRating(rating);
        event.addRating(rating);
        return ratingMapper.toRatingDTO(ratingRepository.save(rating));
    }
}
