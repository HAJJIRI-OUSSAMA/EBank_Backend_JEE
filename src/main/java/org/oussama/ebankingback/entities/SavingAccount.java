package org.oussama.ebankingback.entities;

import jakarta.persistence.*;
import lombok.*;
import org.oussama.ebankingback.enums.AccountStatus;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("SA")
@Data @NoArgsConstructor @AllArgsConstructor
public class SavingAccount extends BankAccount{

    private double interestRate;

}
