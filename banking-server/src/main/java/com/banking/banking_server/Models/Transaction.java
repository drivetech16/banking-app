package com.banking.banking_server.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.apache.bcel.classfile.Code;

import java.util.Collection;

@Entity
@Setter
@Getter
@Table(name = "user_transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int transaction_id;

    @Column
    private  long fromAccountNumber;

    @Column
    private  double senderAccountBalance;


    @Column
    private  long toAccountNumber;

    @Column
    private  double recieverAccountBalance;

   @Column
    private Double transactionAmount;

    @Column
    private String transactionStatus;

    @Column
    private  String transactionDate;

    @Column
    private  String transactionTime;

    @Column
    private  String Description;
}
