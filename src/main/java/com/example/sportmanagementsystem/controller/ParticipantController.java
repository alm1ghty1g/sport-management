package com.example.sportmanagementsystem.controller;


import com.example.sportmanagementsystem.model.Participant;
import com.example.sportmanagementsystem.service.ParticipantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }


    @GetMapping("/participants")
    @Operation(description = "Get all participants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "no participants found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Participant>> retrieveAllParticipants() {
        return ResponseEntity.ok(participantService.retrieveAllParticipants());
    }


    @GetMapping("/participants/{id}")
    @Operation(description = "Get participant by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Participant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Participant> findById(@PathVariable int id) {
        return ResponseEntity.ok(participantService.findById(id));
    }

    @DeleteMapping("/participants/{id}")
    @Operation(description = "Delete participant by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Participant deleted"),
            @ApiResponse(responseCode = "404", description = "Participant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        participantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/participants/{id}")
    @Operation(description = "Update participant by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Participant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Participant> patchById(
            @PathVariable int id,
            @RequestBody Participant updateParticipant) {
        return ResponseEntity.ok(participantService.patchById(id, updateParticipant));
    }

    @PostMapping("/participants")
    @Operation(description = "Create participant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Participant created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Participant> create(@RequestBody Participant createParticipantRequest) {
        Participant response = participantService.createParticipant(createParticipantRequest);
        return ResponseEntity
                .created(URI.create("/participants/" + response.getId()))
                .body(response);
    }
}
