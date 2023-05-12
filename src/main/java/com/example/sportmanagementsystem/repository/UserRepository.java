package com.example.sportmanagementsystem.repository;

import com.example.sportmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    Optional<User> findByEmailAddress(String email);

}
