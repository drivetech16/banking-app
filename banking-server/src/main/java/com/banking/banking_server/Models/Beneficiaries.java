package com.banking.banking_server.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "beneficiaries")
public class Beneficiaries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int beneficiaryId;

    @Column
    private String beneficiaryName;

    @Column
    private Long beneficiaryAccountNumber;

    @Column
    private String relation;

    @ManyToOne
    @JsonBackReference(value = "user_beneficiaries")
    private  User user;

}
