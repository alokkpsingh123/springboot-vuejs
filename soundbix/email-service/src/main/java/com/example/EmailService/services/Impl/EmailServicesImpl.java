package com.example.EmailService.services.Impl;

import com.example.EmailService.entity.EmailDetails;
import com.example.EmailService.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServicesImpl implements EmailServices {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override
    public String sendSimpleMail(EmailDetails details)
        {
            try {

                // Creating a simple mail message
                SimpleMailMessage mailMessage = new SimpleMailMessage();

                mailMessage.setFrom(sender);
                mailMessage.setTo(details.getRecipient());
                mailMessage.setText(details.getMsgBody());
                mailMessage.setSubject("Your order from SoundBix is placed ...");

                // Sending the mail
                javaMailSender.send(mailMessage);

                return "Mail Sent Successfully...";
            }

            // Catch block to handle the exceptions
            catch (Exception e) {
                return "Error while Sending Mail";
            }
        }
    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return null;
    }
}
