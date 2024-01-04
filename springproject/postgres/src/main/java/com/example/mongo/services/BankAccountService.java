package com.example.mongo.services;

import com.example.mongo.dto.BankAccountDto;
import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Employee;

import java.util.Optional;

public interface BankAccountService {

    BankAccount save(BankAccountDto bankAccountDto);

    Iterable<BankAccount> getAll();

    Optional<BankAccount> findOne(String bankId);
}
