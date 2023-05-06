package com.example.sportmanagementsystem.repository;

import com.example.sportmanagementsystem.model.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<SportEvent, Integer> {

    SportEvent findById(int id);


}
