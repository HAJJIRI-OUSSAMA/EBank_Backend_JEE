package org.oussama.ebankingback.entities;

import jakarta.persistence.*;
import lombok.*;
import org.oussama.ebankingback.enums.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class BankAccount {
    // declarer la classe abstract => pour ne pas creer une table BankAccount
    // spring vas creer seulement les classe derivé (concréte) et non pasles classe abstréte
    @Id
    private String id;
    private double balance ;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY) // LAZY chargement fait a la demande
    private List<AccountOperation> accountOperations;

}
