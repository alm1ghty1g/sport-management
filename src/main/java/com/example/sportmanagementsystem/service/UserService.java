package com.example.sportmanagementsystem.service;


import com.example.sportmanagementsystem.model.User;
import com.example.sportmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }


    public User patchById(int id, User updateUser) {
        User user = findById(id);
        user.setFirstName(updateUser.getFirstName());
        user.setFirstName(updateUser.getLastName());
        return userRepository.save(user);
    }


    public User createUser(User createUserRequest) {
        createUserRequest.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        return userRepository.save(createUserRequest);
    }
}
