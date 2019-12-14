package com.sykora.Spring.BankAcc.ThymeLeaf.repository;

import com.sykora.Spring.BankAcc.ThymeLeaf.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
