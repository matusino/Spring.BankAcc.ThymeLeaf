package com.sykora.Spring.BankAcc.ThymeLeaf.domain.service;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Account createAccount(String accountType);
    String createAccountNumber(String snn, String accType, Long id);
    Double depositMoney(Double amount);
    Double withdrawnMoney(Double amount);
    void deleteAccout();
}
