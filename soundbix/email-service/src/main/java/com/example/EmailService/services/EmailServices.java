package com.example.EmailService.services;

import com.example.EmailService.entity.EmailDetails;
import org.springframework.stereotype.Service;

@Service
public interface EmailServices{
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);


}