package com.example.sportmanagementsystem.controller;


import com.example.sportmanagementsystem.model.Reward;
import com.example.sportmanagementsystem.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class RewardController {

    private final RewardService rewardService;


    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }


    @GetMapping("/rewards")
    @Operation(description = "Get all rewards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "No rewards found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Reward>> retrieveAllRewards() {
        return ResponseEntity.ok(rewardService.retrieveAllRewards());
    }


    @GetMapping("/rewards/{id}")
    @Operation(description = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Reward not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Reward> findById(@PathVariable int id) {
        return ResponseEntity.ok(rewardService.findById(id));
    }

    @DeleteMapping("/rewards/{id}")
    @Operation(description = "Delete user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reward deleted"),
            @ApiResponse(responseCode = "404", description = "Reward not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        rewardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/rewards/{id}")
    @Operation(description = "Update user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Reward not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Reward> patchById(
            @PathVariable int id,
            @RequestBody Reward updateReward) {
        return ResponseEntity.ok(rewardService.patchById(id, updateReward));
    }

    @PostMapping("/rewards")
    @Operation(description = "Create reward")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reward created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Reward> create(@RequestBody Reward createRewardRequest) {
        Reward response = rewardService.createReward(createRewardRequest);
        return ResponseEntity
                .created(URI.create("/rewards/" + response.getId()))
                .body(response);
    }

}
