package com.example.sportmanagementsystem.controller;

import com.example.sportmanagementsystem.model.SportEvent;
import com.example.sportmanagementsystem.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    @Operation(description = "Get all events")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "no events found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<SportEvent>> retrieveAllEvents() {
        return ResponseEntity.ok(eventService.retrieveAllEvents());
    }

    @GetMapping("/events/{id}")
    @Operation(description = "Get event by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "event not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<SportEvent> findById(@PathVariable int id) {
        return ResponseEntity.ok(eventService.findById(id));
    }


    @DeleteMapping("/events/{id}")
    @Operation(description = "Delete event by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Event deleted"),
            @ApiResponse(responseCode = "404", description = "Event not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/events/{id}")
    @Operation(description = "Update event by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Event not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<SportEvent> patchById(
            @PathVariable int id,
            @RequestBody SportEvent updateEvent) {
        return ResponseEntity.ok(eventService.patchById(id, updateEvent));
    }

    @PostMapping("/events")
    @Operation(description = "Create event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Event created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<SportEvent> create(@RequestBody SportEvent createEventRequest) {
        SportEvent response = eventService.createEvent(createEventRequest);
        return ResponseEntity
                .created(URI.create("/events/" + response.getId()))
                .body(response);
    }



}
