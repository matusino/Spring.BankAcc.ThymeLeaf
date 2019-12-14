package com.sykora.Spring.BankAcc.ThymeLeaf.domain;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends Account {

    private String safetyDepositBox;
    private String pinTosafetyBox;

    public String getPinTosafetyBox() {
        return pinTosafetyBox;
    }

    public void setPinTosafetyBox(String pinTosafetyBox) {
        this.pinTosafetyBox = pinTosafetyBox;
    }

    public SavingsAccount() {
    }

    public String getSafetyDepositBox() {
        return safetyDepositBox;
    }

    public void setSafetyDepositBox(String safetyDepositBox) {
        this.safetyDepositBox = safetyDepositBox;
    }
}
