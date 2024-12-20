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
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);

    }


    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }


    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
                                                       @RequestParam(name = "page",defaultValue = "0") int page,
                                                       @RequestParam(name = "page",defaultValue = "5")int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }

}
