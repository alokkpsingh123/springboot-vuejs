package com.example.mongo.dto;

import lombok.Data;

@Data
public class BankAccountResponseDto {
    private String id;

    private String bankName;

    private String accountNumber;
}
