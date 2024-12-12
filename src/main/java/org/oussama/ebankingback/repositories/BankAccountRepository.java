package org.oussama.ebankingback.repositories;

import org.oussama.ebankingback.entities.BankAccount;
import org.oussama.ebankingback.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
