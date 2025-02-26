package com.banking.banking_server.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "user_bankaccount")
public class BankAccount {
    @Id
    @Column
    private Long accountNumber;

    @Column
    private String accountType;

    @Column
    private String accountCreatedDate;

    @Column
    private  String getAccountCreatedTime;

    @Column
    private Double accountBalance;


    private boolean isAccountActive;

    @ManyToOne
    @JsonBackReference(value = "user_account")
    private  User user;

}
