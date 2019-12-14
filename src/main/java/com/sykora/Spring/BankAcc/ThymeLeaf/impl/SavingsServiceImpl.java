package com.sykora.Spring.BankAcc.ThymeLeaf.impl;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.service.SavingsService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SavingsServiceImpl implements SavingsService {
    @Override
    public String setSafetyDepositBox() {
        Random random = new Random();
        return Integer.toString(random.nextInt(9000) +1000);
    }

    @Override
    public String setPinToSafetyBox() {
        Random random = new Random();
        return Integer.toString(random.nextInt(900) +100);
    }
}
