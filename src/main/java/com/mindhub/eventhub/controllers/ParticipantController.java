package com.mindhub.eventhub.controllers;

import com.mindhub.eventhub.dtos.EventAttendDTO;
import com.mindhub.eventhub.dtos.records.ParticipantCreateDTO;
import com.mindhub.eventhub.dtos.ParticipantDTO;
import com.mindhub.eventhub.services.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/p")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping("/participants")
    public ResponseEntity<ParticipantDTO> createParticipant(@Valid @RequestBody ParticipantCreateDTO participantCreateDTO) {
        return new ResponseEntity<>(participantService.createParticpant(participantCreateDTO), HttpStatus.CREATED);
    }

    @GetMapping("/participants/auth")
    public ResponseEntity<ParticipantDTO> getAuthParticipant(Authentication authentication) {
        return new ResponseEntity<>(participantService.getParticipantByEmail(authentication.getName()), HttpStatus.OK);
    }

    @PostMapping("/participants/{eventId}")
    public ResponseEntity<?> registerEvent(@PathVariable("eventId") UUID eventId) {
        participantService.registerEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/participants/")
    public ResponseEntity<List<EventAttendDTO>> getEventAttends() {
        return new ResponseEntity<>(participantService.getEventAttends(), HttpStatus.OK);
    }
}
