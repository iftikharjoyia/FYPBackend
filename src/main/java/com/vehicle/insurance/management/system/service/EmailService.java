package com.vehicle.insurance.management.system.service;

import com.vehicle.insurance.management.system.models.UserOTP;
import com.vehicle.insurance.management.system.repository.UserOTPRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Function;

@Service
public  class EmailService {

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        String from = "iftikharjoyia2324@gmail.com";
        // Setup mail server properties
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("iftikharjoyia2324@gmail.com", "dsfqvmokqifvzdrs");
            }
        });
        session.setDebug(true);
        // Create a default MimeMessage object
        MimeMessage message = new MimeMessage(session);

        // Set From: header field
        message.setFrom(from);

        // Set To: header field
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Set Subject: header field
        message.setSubject(subject);

        // Now set the actual message
        message.setText(body);
        try {
            Transport.send(message);
        } catch (Exception e) {
            System.out.println("error");
        }
        // Send message

    }

}