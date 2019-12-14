package com.sykora.Spring.BankAcc.ThymeLeaf.impl;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Account;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.CheckingAccount;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.SavingsAccount;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.service.AccountService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public Account createAccount(String accountType) {
        if(accountType.equalsIgnoreCase("checking")){
            return new CheckingAccount();
        }else if(accountType.equalsIgnoreCase("savings")){
            return new SavingsAccount();
        }
        return null;
    }

    @Override
    public String createAccountNumber(String snn, String accType, Long id) {
        Random random = new Random();
        String newAccountNumber;
        String prefix = "";
        String lastTwoDigits = snn.substring(snn.length()-2);
        String uniqueNumber= Long.toString(id);
        String randomNumber = Integer.toString(random.nextInt(900) +100);

        if(accType.equalsIgnoreCase("checking")){
            prefix = "1";
        }else if(accType.equalsIgnoreCase("savings")){
            prefix = "2";
        }
        newAccountNumber = prefix+lastTwoDigits+uniqueNumber+randomNumber;
        return newAccountNumber;
    }

    @Override
    public Double depositMoney(Double amount) {
        return null;
    }

    @Override
    public Double withdrawnMoney(Double amount) {
        return null;
    }




    @Override
    public void deleteAccout() {

    }
}
