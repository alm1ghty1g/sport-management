package com.example.sportmanagementsystem.repository;

import com.example.sportmanagementsystem.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Integer> {

    Reward findById(int id);

}
