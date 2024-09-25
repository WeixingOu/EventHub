package com.mindhub.eventhub.init;

import com.mindhub.eventhub.models.*;
import com.mindhub.eventhub.enums.*;
import com.mindhub.eventhub.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final ParticipantRepository participantRepository;
    private final ManagerRepository managerRepository;
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    private final EventLocationRepository eventLocationRepository;
    private final CustomerEventRepository customerEventRepository;
    private final CommentRepository commentRepository;
    private final RatingRepository ratingRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(
        ParticipantRepository participantRepository,
        EventRepository eventRepository,
        LocationRepository locationRepository,
        EventLocationRepository eventLocationRepository,
        CustomerEventRepository customerEventRepository,
        CommentRepository commentRepository,
        RatingRepository ratingRepository,
        CategoryRepository categoryRepository,
        ManagerRepository managerRepository,
        PasswordEncoder passwordEncoder
    ) {
        this.participantRepository = participantRepository;
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
        this.eventLocationRepository = eventLocationRepository;
        this.customerEventRepository = customerEventRepository;
        this.commentRepository = commentRepository;
        this.ratingRepository = ratingRepository;
        this.categoryRepository = categoryRepository;
        this.managerRepository = managerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Manager manager1 = new Manager("John", "Doe", "john.doe@example.com", passwordEncoder.encode("password123"), (short) 30, Gender.MALE, Role.MANAGER);
        Participant participant1 = new Participant("Jane", "Smith", "jane.smith@example.com", passwordEncoder.encode("password123"), (short) 25, Gender.FEMALE, Role.PARTICIPANT);
        managerRepository.save(manager1);
        participantRepository.save(participant1);

        Category category1 = new Category("Music");
        Category category2 = new Category("Sports");
        Category category3 = new Category("Theater");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        Event event1 = new Event("Concert by the lake", "concert.jpg", (short) 18, "Lake Music Fest");
        Event event2 = new Event("Football Championship", "football.jpg", (short) 12, "Local Football Championship");

        event1.addCategories(category1);
        event1.addCategories(category3);

        event2.addCategories(category2);
        event2.addCategories(category3);

        manager1.addEvent(event1);
        manager1.addEvent(event2);

        eventRepository.save(event1);
        eventRepository.save(event2);

        Location location1 = new Location("Main Stadium", "stadium.jpg");
        Location location2 = new Location("City Theater", "theater.jpg");
        locationRepository.save(location1);
        locationRepository.save(location2);

        EventLocation eventLocation1 = new EventLocation(LocalDate.of(2024, 5, 20), 500);
        event1.addEventLocation(eventLocation1);
        location1.addEventLocation(eventLocation1);
        eventLocationRepository.save(eventLocation1);

        EventLocation eventLocation2 = new EventLocation(LocalDate.of(2024, 6, 10), 300);
        event2.addEventLocation(eventLocation2);
        location2.addEventLocation(eventLocation2);
        eventLocationRepository.save(eventLocation2);

        CustomerEvent customerEvent1 = new CustomerEvent(true);
        event1.addParticipants(customerEvent1);
        participant1.addCustomerEvent(customerEvent1);
        customerEventRepository.save(customerEvent1);

        CustomerEvent customerEvent2 = new CustomerEvent(false);
        event2.addParticipants(customerEvent2);
        participant1.addCustomerEvent(customerEvent2);
        customerEventRepository.save(customerEvent2);

        Comment comment1 = new Comment("Amazing concert!");
        participant1.addComment(comment1);
        event1.addComment(comment1);
        commentRepository.save(comment1);

        Comment comment2 = new Comment("Looking forward to this event.");
        manager1.addComment(comment2);
        event2.addComment(comment2);
        commentRepository.save(comment2);

        Rating rating1 = new Rating(5);
        participant1.addRating(rating1);
        event1.addRating(rating1);
        ratingRepository.save(rating1);

        Rating rating2 = new Rating(4);
        manager1.addRating(rating2);
        event2.addRating(rating2);
        ratingRepository.save(rating2);
    }
}
