package com.sykora.Spring.BankAcc.ThymeLeaf.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


public class Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String Snn;
    @Nullable
    private String phoneNumber;
    @Nullable
    private String age;

    public Person(Long id, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String snn, @Nullable String phoneNumber, @Nullable String age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Snn = snn;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSnn() {
        return Snn;
    }

    public void setSnn(String snn) {
        Snn = snn;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public String getAge() {
        return age;
    }

    public void setAge(@Nullable String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(Snn, person.Snn) &&
                Objects.equals(phoneNumber, person.phoneNumber) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, Snn, phoneNumber, age);
    }
}
