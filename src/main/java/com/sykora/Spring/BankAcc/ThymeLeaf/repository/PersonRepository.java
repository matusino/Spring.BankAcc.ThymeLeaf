package com.sykora.Spring.BankAcc.ThymeLeaf.repository;


import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
