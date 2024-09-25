package com.mindhub.eventhub.controllers;

import com.mindhub.eventhub.dtos.ParticipantCreateDTO;
import com.mindhub.eventhub.dtos.ParticipantDTO;
import com.mindhub.eventhub.services.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
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
}
