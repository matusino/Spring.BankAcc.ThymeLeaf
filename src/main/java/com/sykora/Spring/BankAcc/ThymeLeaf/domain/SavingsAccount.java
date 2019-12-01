package com.sykora.Spring.BankAcc.ThymeLeaf.domain;

public class SavingsAccount extends Account {

    private String safetyDepositBox;

    public SavingsAccount() {
    }

    public String getSafetyDepositBox() {
        return safetyDepositBox;
    }

    public void setSafetyDepositBox(String safetyDepositBox) {
        this.safetyDepositBox = safetyDepositBox;
    }
}
