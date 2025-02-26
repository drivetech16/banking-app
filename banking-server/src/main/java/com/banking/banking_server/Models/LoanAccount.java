package com.banking.banking_server.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "loan_account")
public class LoanAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanAccountNumber;

    @Column
    private Double loanIssuedAmount;

    @Column
    private Double loanRemainingAmount;

    @Column
    private Double loanInterestRate;

    @Column
    private String loanPurpose;

    @Column
    private int tenureMonths;

    @Column
    private int MonthlyEMI;

    @ManyToOne
    @JsonBackReference(value = "user_loan")
    private  User user;

    @OneToOne
    @JsonBackReference
    private BankAccount bankAccount;
}
