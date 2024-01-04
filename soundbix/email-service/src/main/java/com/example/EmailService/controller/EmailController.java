package com.example.EmailService.controller;

import com.example.EmailService.entity.EmailDetails;
import com.example.EmailService.services.EmailServices;
import com.example.EmailService.services.Impl.EmailServicesImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/email")

public class EmailController {

   @Autowired
    EmailServices emailServices;

    @PostMapping("/sendMail")
    public String sendMail(@org.springframework.web.bind.annotation.RequestBody EmailDetails details)
    {
        String status = emailServices.sendSimpleMail(details);

        return status;
    }

}
