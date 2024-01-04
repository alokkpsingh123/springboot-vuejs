package com.example.EmailService.entity;

import jdk.jfr.DataAmount;
import lombok.Data;


@Data
public class EmailDetails {
    private String recipient;
    private String orderId;
    private String msgBody;
}
