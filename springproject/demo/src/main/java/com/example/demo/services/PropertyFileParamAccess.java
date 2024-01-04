package com.example.demo.services;

import org.springframework.beans.factory.annotation.Value;

public class PropertyFileParamAccess {

    @Value("${example.intValue:0}")
    int number;

    String message;
}
