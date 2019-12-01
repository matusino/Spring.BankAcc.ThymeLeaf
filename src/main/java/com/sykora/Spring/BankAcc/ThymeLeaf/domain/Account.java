package com.sykora.Spring.BankAcc.ThymeLeaf.domain;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public abstract class Account {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotEmpty
    private String accountNumber;
    @NotEmpty
    private Double balance;

//    @ManyToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Account(Long id, @NotEmpty String accountNumber, @NotEmpty Double balance) {
        Id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(Id, account.Id) &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, accountNumber, balance);
    }
}
