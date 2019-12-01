package com.sykora.Spring.BankAcc.ThymeLeaf.domain;


public class CheckingAccount extends Account{

    private String cardNumber;

    public CheckingAccount() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
