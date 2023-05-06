package com.example.sportmanagementsystem.controller;


import com.example.sportmanagementsystem.model.Organization;
import com.example.sportmanagementsystem.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class OrganizationController {

    private final OrganizationService organizationService;


    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations")
    @Operation(description = "Get all organizations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No organizations found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Organization>> retrieveAllOrganizations() {
        return ResponseEntity.ok(organizationService.retrieveAllOrganizations());
    }


    @GetMapping("/organizations/{id}")
    @Operation(description = "Get organization by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Organization not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Organization> findById(@PathVariable int id) {
        return ResponseEntity.ok(organizationService.findById(id));
    }

    @DeleteMapping("/organizations/{id}")
    @Operation(description = "Delete organization by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Organization deleted"),
            @ApiResponse(responseCode = "404", description = "Organization not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        organizationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/organizations/{id}")
    @Operation(description = "Update organization by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Organization not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Organization> patchById(
            @PathVariable int id,
            @RequestBody Organization updateOrganization) {
        return ResponseEntity.ok(organizationService.patchById(id, updateOrganization));
    }

    @PostMapping("/organizations")
    @Operation(description = "Create organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Organization created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Organization> create(@RequestBody Organization createOrganizationRequest) {
        Organization response = organizationService.createOrganization(createOrganizationRequest);
        return ResponseEntity
                .created(URI.create("/organizations/" + response.getId()))
                .body(response);
    }
}
