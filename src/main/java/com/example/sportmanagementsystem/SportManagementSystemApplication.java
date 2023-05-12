package com.example.sportmanagementsystem;

import com.example.sportmanagementsystem.model.User;
import com.example.sportmanagementsystem.service.EmailSenderService;
import com.example.sportmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SportManagementSystemApplication {

    private final EmailSenderService emailSenderService;

    private final UserService userService;

    @Autowired
    public SportManagementSystemApplication(EmailSenderService emailSenderService, UserService userService) {
        this.emailSenderService = emailSenderService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SportManagementSystemApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createAdminUser() {
        User adminUser = new User(9999,
                "admin",
                "admin",
                "admin@gmail.com",
                "123",
                "ROLE_ADMIN",
                new ArrayList<>());

        userService.createUser(adminUser);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        emailSenderService.collectEvents();
    }
}
