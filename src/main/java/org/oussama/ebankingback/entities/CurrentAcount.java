package org.oussama.ebankingback.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("CA")
@Data @NoArgsConstructor @AllArgsConstructor
public class CurrentAcount extends BankAccount{

    private double overDraft;
}