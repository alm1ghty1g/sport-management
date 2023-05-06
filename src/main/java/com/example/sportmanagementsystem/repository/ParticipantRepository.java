package com.example.sportmanagementsystem.repository;

import com.example.sportmanagementsystem.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    Participant findById(int id);

}
