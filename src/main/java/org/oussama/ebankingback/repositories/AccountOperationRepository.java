package org.oussama.ebankingback.repositories;

import org.oussama.ebankingback.entities.AccountOperation;
import org.oussama.ebankingback.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
