package com.example.mongo.services.impl;


import com.example.mongo.dto.BankAccountDto;
import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Employee;
import com.example.mongo.repository.BankAccountRepository;
import com.example.mongo.repository.EmployeeRepository;
import com.example.mongo.services.BankAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountServiceImp implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount save(BankAccountDto bankAccountDto) {

        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountDto, bankAccount);
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public Iterable<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public Optional<BankAccount> findOne(String bankId) {
        return bankAccountRepository.findById(bankId);
    }
}
