package com.softserve2020practice.services.impl;

import com.softserve2020practice.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSender {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public void sendMessage(Account user, String password) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String message = String.format(
                "Hello, student! Welcome to IT Academy! " +
                        "\nPlease find your login credential below." +
                        "\nYour email: " + user.getEmail() +
                        "\nYour generated password: " + password +
                        "\nGood luck!"
        );

        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Login credentials");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
