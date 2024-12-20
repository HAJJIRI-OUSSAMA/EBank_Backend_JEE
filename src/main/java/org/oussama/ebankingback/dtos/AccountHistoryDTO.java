package org.oussama.ebankingback.dtos;

import lombok.*;

import java.util.*;

@Data
public class AccountHistoryDTO {
    private String accountId;
    private double balance;
    private int currentPage;
    private int totalPages;
    private int pageSize;

    private List<AccountOperationDTO> accountOperationDTOS;


}
