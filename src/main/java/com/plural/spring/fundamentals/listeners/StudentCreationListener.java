package com.plural.spring.fundamentals.listeners;

import com.plural.spring.fundamentals.events.StudentCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCreationListener implements ApplicationListener<StudentCreationEvent> {

    private final JavaMailSender javaMailSender;

    @Override
    public void onApplicationEvent(StudentCreationEvent studentCreationEvent) {
        String username = studentCreationEvent.getStudent().getFirstName();
        Long id = studentCreationEvent.getStudent().getId();
        String email = studentCreationEvent.getStudent().getEmailId();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("User registration verification");
        message.setText(String.format("Thanks %s for creating an account. " +
                        "Please verify your email by clicking the link: http://localhost:8080/verify?id=%d", username, id));
        message.setTo(email);
        javaMailSender.send(message);
    }
}