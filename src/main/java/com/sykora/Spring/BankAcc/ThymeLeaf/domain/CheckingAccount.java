package com.sykora.Spring.BankAcc.ThymeLeaf.domain;


import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

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

    public CheckingAccount(Long id, @NotEmpty String accountNumber, @NotEmpty Double balance, String cardNumber, String pin) {
        super(id, accountNumber, balance);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
