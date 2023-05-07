package com.example.sportmanagementsystem;

import com.example.sportmanagementsystem.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SportManagementSystemApplication {

    private final EmailSenderService emailSenderService;

    @Autowired
    public SportManagementSystemApplication(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SportManagementSystemApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        emailSenderService.collectEvents();
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail() {
//        emailSenderService.sendEmail("allm1ghty1g@gmail.com",
//                "This is subject",
//                "This is a body of email");
//    }

}
