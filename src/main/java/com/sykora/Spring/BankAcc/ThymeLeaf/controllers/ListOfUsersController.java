package com.sykora.Spring.BankAcc.ThymeLeaf.controllers;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Account;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Person;
import com.sykora.Spring.BankAcc.ThymeLeaf.repository.AccountRepository;
import com.sykora.Spring.BankAcc.ThymeLeaf.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListOfUsersController {

    private final PersonRepository personRepository;
    private final AccountRepository accountRepository;

    public ListOfUsersController(PersonRepository personRepository, AccountRepository accountRepository) {
        this.personRepository = personRepository;
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/listofpersons")
    public String listOfPersons(Model model){
        List<Person> list = new ArrayList<>();

        personRepository.findAll().forEach(list::add);
        model.addAttribute("persons", list);

        return "listofpersons";
    }
}
