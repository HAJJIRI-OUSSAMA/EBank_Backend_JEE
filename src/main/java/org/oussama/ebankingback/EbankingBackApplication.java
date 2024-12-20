package org.oussama.ebankingback;
import jakarta.transaction.Transactional;
import org.oussama.ebankingback.dtos.*;
import org.oussama.ebankingback.entities.*;
import org.oussama.ebankingback.enums.AccountStatus;
import org.oussama.ebankingback.enums.OperationType;
import org.oussama.ebankingback.exeption.*;
import org.oussama.ebankingback.repositories.AccountOperationRepository;
import org.oussama.ebankingback.repositories.BankAccountRepository;
import org.oussama.ebankingback.repositories.CustomerRepository;
import org.oussama.ebankingback.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankingBackApplication.class, args);
	}
	@Bean

	CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
		return args -> {
			Stream.of("oussama","yassine","hicham").forEach(name->{
				CustomerDTO customer = new CustomerDTO();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");

				bankAccountService.saveCustomer(customer);
			});
			bankAccountService.listCustomers().forEach(customer->{
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*9000,9000,customer.getId());
					bankAccountService.saveSavingBankAccount(Math.random()*120000,5.4, customer.getId());

				} catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
			List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
			for (BankAccountDTO bankAccount:bankAccounts) {
				for (int i = 0; i <10 ; i++) {
					String accountId;
					if (bankAccount instanceof SavingBankAccountDTO){
						accountId=((SavingBankAccountDTO) bankAccount).getId();
					}else{
						accountId=((CurrentBankAccountDTO) bankAccount).getId();

					}
					bankAccountService.credit(accountId, 10000+Math.random()*120000,"Credit");
					bankAccountService.debit(accountId, 1000+Math.random()*8000,"Debit");
				}
			}
		};
	}
//	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							BankAccountRepository bankAccountRepository,
							AccountOperationRepository accountOperationRepository){
		return args -> {
			Stream.of("oussama","hakim","hicham").forEach(name->{
				Customer customer =new Customer();
				customer.setName(name);
				customer.setEmail(name+"@mundiapolis.ma");
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(cust->{
				CurrentAccount currentAccount = new CurrentAccount();
				currentAccount.setId(UUID.randomUUID().toString());
				currentAccount.setBalance(Math.random()*3000);
				currentAccount.setCreatedAt(new Date());
				currentAccount.setStatus(AccountStatus.CREATED);
				currentAccount.setCustomer(cust);
				currentAccount.setOverDraft(5000);
				bankAccountRepository.save(currentAccount);

				SavingAccount savingAccount = new SavingAccount();
				savingAccount.setId(UUID.randomUUID().toString());
				savingAccount.setBalance(Math.random()*3000);
				savingAccount.setCreatedAt(new Date());
				savingAccount.setStatus(AccountStatus.CREATED);
				savingAccount.setCustomer(cust);
				savingAccount.setInterestRate(4.2);
				bankAccountRepository.save(savingAccount);
			});

			bankAccountRepository.findAll().forEach(acc->{
				for (int i=0 ;i<8;i++){
					AccountOperation accountOperation = new AccountOperation();
					accountOperation.setOperationDate(new Date());
					accountOperation.setAmount(Math.random()*10000);
					accountOperation.setType(Math.random()>0.5 ? OperationType.DEBIT :OperationType.CREDIT );
					//cette operation ca concerne qu'elle compte
					accountOperation.setBankAccount(acc);
					//Pour enregister le compte :
					accountOperationRepository.save(accountOperation);
				}
			});


		};

	}
}
