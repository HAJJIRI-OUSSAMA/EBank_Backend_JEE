package org.oussama.ebankingback.dtos;

import jakarta.persistence.*;
import lombok.*;
import org.oussama.ebankingback.entities.*;
import org.oussama.ebankingback.enums.*;

import java.util.*;

@Data
public class CurrentBankAccountDTO extends BankAccountDTO{

    private String id;
    private double balance ;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;

}
