package org.oussama.ebankingback.services;

import org.oussama.ebankingback.entities.BankAccount;
import org.oussama.ebankingback.entities.CurrentAccount;
import org.oussama.ebankingback.entities.SavingAccount;
import org.oussama.ebankingback.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter  ( ){
        BankAccount bankAccount =
                bankAccountRepository.findById("01e83b65-e1ea-4679-8a9b-d9d78afe1018").orElse(null);
        if (bankAccount != null) {

            System.out.println("******************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            // pour afficher le type de compte
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) { // si le compte c'eat un compte courant
                System.out.println("OverDraft : " + ((CurrentAccount) bankAccount).getOverDraft());
                ;
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("RATE : " + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(ops -> {
                System.out.println(ops.getType() + "\t" + ops.getOperationDate() + "\t" + ops.getAmount());

            });
        }
    }
}
