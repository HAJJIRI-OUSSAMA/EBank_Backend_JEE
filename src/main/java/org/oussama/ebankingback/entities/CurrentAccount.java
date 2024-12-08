package org.oussama.ebankingback.entities;

import jakarta.persistence.*;
import lombok.*;
import org.oussama.ebankingback.enums.AccountStatus;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("CA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAcount extends BankAccount{
    @Id
    private double overDraft;

}
