package org.oussama.ebankingback.web;


import org.oussama.ebankingback.dtos.*;
import org.oussama.ebankingback.exeption.*;
import org.oussama.ebankingback.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BankAccountRestController {

    private BankAccountService bankAccountService;


    public BankAccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accounId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accounId);

    }


    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }

}
