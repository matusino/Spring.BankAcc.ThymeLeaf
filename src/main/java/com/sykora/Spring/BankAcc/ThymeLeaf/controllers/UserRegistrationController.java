package com.sykora.Spring.BankAcc.ThymeLeaf.controllers;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Account;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.CheckingAccount;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Person;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.SavingsAccount;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.service.AccountService;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.service.CheckingService;
import com.sykora.Spring.BankAcc.ThymeLeaf.domain.service.SavingsService;
import com.sykora.Spring.BankAcc.ThymeLeaf.repository.AccountRepository;
import com.sykora.Spring.BankAcc.ThymeLeaf.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    private final PersonRepository personRepository;
    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final CheckingService checkingService;
    private final SavingsService savingsService;

    public UserRegistrationController(PersonRepository personRepository, AccountService accountService, AccountRepository accountRepository, CheckingService checkingService, SavingsService savingsService) {
        this.personRepository = personRepository;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.checkingService = checkingService;
        this.savingsService = savingsService;
    }

    @RequestMapping(value = "/registration")
    public String registrationForm(Model model){
        model.addAttribute("person", new Person());
        return "registrationform";
    }

    @RequestMapping(value = "/registrationcomplete", method = RequestMethod.POST)
    public String registerUserForm(@Valid @ModelAttribute Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registrationform";
        }
        //save person entity to table
        personRepository.save(person);

        //create acc, bind with person and save
        Account account = accountService.createAccount(person.getAccountType());
        account.setAccountNumber(accountService.createAccountNumber(person.getSnn(),person.getAccountType(),person.getId()));

        if(account instanceof CheckingAccount){
            ((CheckingAccount) account).setCardNumber(checkingService.createCardNumber());
            ((CheckingAccount) account).setPin(checkingService.randomPin());
            account.setPerson(person);
            accountRepository.save(account);
        }else if(account instanceof SavingsAccount){
            ((SavingsAccount) account).setSafetyDepositBox(savingsService.setSafetyDepositBox());
            ((SavingsAccount) account).setPinTosafetyBox(savingsService.setPinToSafetyBox());
            account.setPerson(person);
            accountRepository.save(account);
        }
        return "redirect:/listofpersons";
    }

    @RequestMapping(value = "/modifyAccount/{personId}", method = RequestMethod.GET)
    public String modify(@PathVariable Long personId, Model model){
        Person person = personRepository.findById(personId).orElse(null);
        Account account = accountRepository.findById(personId).orElse(null);

        model.addAttribute("person", person);
        model.addAttribute("account", account);

        return "modifyperson";
    }
    @RequestMapping(value = "/modifycomplete/{userId}", method = RequestMethod.POST)
    public String modifyComplete(@PathVariable Long userId, @ModelAttribute Person person, @ModelAttribute Account account){
        Person updatedPerson = personRepository.findById(userId).orElse(null);
        Account updatedAccount = accountRepository.findById(userId).orElse(null);

        //update person
        updatedPerson.setFirstName(person.getFirstName());
        updatedPerson.setLastName(person.getLastName());
        updatedPerson.setSnn(person.getSnn());
        updatedPerson.setPhoneNumber(person.getPhoneNumber());

        //update balance
        updatedAccount.setBalance(account.getBalance());

        //update both entities
        personRepository.save(updatedPerson);
        accountRepository.save(updatedAccount);

        return "redirect:/listofpersons";
        //sem daj redirect
    }
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long userId){
        personRepository.deleteById(userId);
        return "redirect:/listofpersons";
    }
}
