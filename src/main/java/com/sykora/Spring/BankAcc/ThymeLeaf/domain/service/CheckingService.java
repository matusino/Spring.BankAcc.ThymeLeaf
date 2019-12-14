package com.sykora.Spring.BankAcc.ThymeLeaf.domain.service;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.CheckingAccount;
import org.springframework.stereotype.Service;

@Service
public interface CheckingService {

    String createCardNumber();
    String randomPin();
}
