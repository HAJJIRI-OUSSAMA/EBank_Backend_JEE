package org.oussama.ebankingback.dtos;

import jakarta.persistence.*;
import lombok.*;
import org.oussama.ebankingback.entities.*;
import org.oussama.ebankingback.enums.*;

import java.util.*;

@Data
public class AccountOperationDTO {

    private Long id;
    private Date operationDate;
    private double amount ;
    private OperationType type;
    private String description;


}
