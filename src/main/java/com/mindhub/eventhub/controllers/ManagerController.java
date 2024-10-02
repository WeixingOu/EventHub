package com.mindhub.eventhub.controllers;

import com.mindhub.eventhub.dtos.records.EventCreateDTO;
import com.mindhub.eventhub.dtos.EventDTO;
import com.mindhub.eventhub.dtos.records.EventLocationCreateDTO;
import com.mindhub.eventhub.dtos.EventLocationDTO;
import com.mindhub.eventhub.dtos.EventAttendDTO;
import com.mindhub.eventhub.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/m")
public class ManagerController {
    @Autowired
    private EventService eventService;
    @PostMapping("/events")
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventCreateDTO eventCreateDTO) {
        return new ResponseEntity<>(eventService.createEvent(eventCreateDTO), HttpStatus.CREATED);
    }

    @PostMapping("/eventlocations")
    public ResponseEntity<EventLocationDTO> createEventLocation(@Valid @RequestBody EventLocationCreateDTO eventLocationCreateDTO) {
        return new ResponseEntity<>(eventService.createEventLocation(eventLocationCreateDTO), HttpStatus.CREATED);
    }

    @PostMapping("/events/{eventId}/ce")
    public ResponseEntity<?> cancelEvent(@PathVariable("eventId")  UUID eventId) {
        eventService.cancelEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/eventlocations/{eventLocationId}")
    public ResponseEntity<?> canceEventLocation(@PathVariable("eventLocationId") UUID eventLocationId) {
        eventService.cancelEventLocation(eventLocationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getEventsByManager() {
        return new ResponseEntity<>(eventService.getEventsByManager(), HttpStatus.OK);
    }

    @PostMapping("/events/{eventId}/ra")
    public ResponseEntity<EventAttendDTO> registerAttend(@PathVariable("eventId")  UUID eventId, @RequestParam UUID participantId, @RequestParam UUID eventLocationId) {
        return new ResponseEntity<>(eventService.registerAttend(eventId, participantId, eventLocationId), HttpStatus.OK);
    }
}
