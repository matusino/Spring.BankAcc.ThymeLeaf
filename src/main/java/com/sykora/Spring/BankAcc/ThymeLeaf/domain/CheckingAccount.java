package com.sykora.Spring.BankAcc.ThymeLeaf.domain;


import javax.persistence.Entity;

@Entity
public class CheckingAccount extends Account{

    private String cardNumber;

    private String pin;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public CheckingAccount() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
