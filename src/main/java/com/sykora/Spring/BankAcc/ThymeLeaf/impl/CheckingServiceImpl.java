package com.sykora.Spring.BankAcc.ThymeLeaf.impl;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.CheckingAccount;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.service.CheckingService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CheckingServiceImpl implements CheckingService {

    @Override
    public String createCardNumber() {
        Random random = new Random();
        Long randomNumber = Math.round(random.nextFloat() * Math.pow(10,12));
        return String.valueOf(randomNumber);
    }

    @Override
    public String randomPin() {
        Random random = new Random();
        int randomPin = random.nextInt(9000)+1000;
        return String.valueOf(randomPin);
    }
}
