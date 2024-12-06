package org.oussama.ebankingback.entities;

import jakarta.persistence.*;
import org.oussama.ebankingback.enums.*;

import java.util.*;

import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount ;
    private OperationType type;
    @ManyToOne
    private BankAccount bankAccount;


}
