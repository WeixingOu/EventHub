package com.mindhub.eventhub.controllers;

import com.mindhub.eventhub.dtos.*;
import com.mindhub.eventhub.dtos.records.CommentCreateDTO;
import com.mindhub.eventhub.dtos.records.RatingCreateDTO;
import com.mindhub.eventhub.services.CommentService;
import com.mindhub.eventhub.services.EventService;
import com.mindhub.eventhub.services.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RatingService ratingService;

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @PostMapping("/events/{eventId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable("eventId") String eventId, @Valid @RequestBody CommentCreateDTO commentCreateDTO) {
        return new ResponseEntity<>(commentService.createComment(eventId, commentCreateDTO), HttpStatus.CREATED);
    }

    @PostMapping("/events/{eventId}/ratings")
    public ResponseEntity<RatingDTO> createRating(@PathVariable("eventId") String evenId, @Valid @RequestBody RatingCreateDTO ratingCreateDTO) {
        return new ResponseEntity<>(ratingService.createRating(evenId, ratingCreateDTO), HttpStatus.CREATED);
    }
}
