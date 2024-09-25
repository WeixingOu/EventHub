package com.mindhub.eventhub.controllers;

import com.mindhub.eventhub.dtos.CommentCreateDTO;
import com.mindhub.eventhub.dtos.CommentDTO;
import com.mindhub.eventhub.dtos.EventDTO;
import com.mindhub.eventhub.dtos.ParticipantDTO;
import com.mindhub.eventhub.mappers.ParticipantMapper;
import com.mindhub.eventhub.repositories.ParticipantRepository;
import com.mindhub.eventhub.services.CommentService;
import com.mindhub.eventhub.services.EventService;
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

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @PostMapping("/events/{eventId}")
    public ResponseEntity<CommentDTO> createComment(@PathVariable String eventId, @Valid @RequestBody CommentCreateDTO commentCreateDTO) {
        return new ResponseEntity<>(commentService.createComment(eventId, commentCreateDTO), HttpStatus.CREATED);
    }
}
