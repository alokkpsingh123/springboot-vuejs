package com.example.mongo.controller;

import com.example.mongo.dto.*;
import com.example.mongo.entity.BankAccount;
import com.example.mongo.entity.Company;
import com.example.mongo.entity.Employee;
import com.example.mongo.services.BankAccountService;
import com.example.mongo.services.ComanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @PostMapping
    public BankAccount save(@RequestBody BankAccountDto bankAccountDto){
        return bankAccountService.save(bankAccountDto);
    }

    @GetMapping("/findAll")
    public List<BankAccountResponseDto> findAll(){

        Iterable<BankAccount> bankAccounts =  bankAccountService.getAll();
        List<BankAccountResponseDto> bankAccountDtos = new ArrayList<>();
        for( BankAccount bankAccount : bankAccounts){
            BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
            BeanUtils.copyProperties(bankAccount, bankAccountResponseDto);
            bankAccountDtos.add(bankAccountResponseDto);
        }

        return bankAccountDtos;
    }
}
