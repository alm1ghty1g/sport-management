package com.example.sportmanagementsystem.service;


import com.example.sportmanagementsystem.model.SportEvent;
import com.example.sportmanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
public class EmailSenderService {

    private final UserService userService;

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(UserService userService, JavaMailSender javaMailSender) {
        this.userService = userService;
        this.javaMailSender = javaMailSender;
    }

    public void collectEvents() {
        List<User> userList = userService.retrieveAllUsers();
        for (User user : userList) {
            List<SportEvent> eventList = user.getEventList();
            for (SportEvent event : eventList) {
                if (checkDifference(event.getEventDate())) {
                    sendEmail(user.getEmailAddress(), "this is subject", event.getEventName());
                }
            }
        }
    }

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kirill.sazonov64@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);

        System.out.println("Mail sent successfully...");
    }



    public boolean checkDifference(LocalDate eventDay) {
        LocalDate today = LocalDate.now();
        long difference = ChronoUnit.DAYS.between(today, eventDay);
        return difference < 7;
    }
}
