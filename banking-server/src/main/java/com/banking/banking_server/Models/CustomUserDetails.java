package com.banking.banking_server.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user_details")
public class CustomUserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int userdetailid;
    @Column
    private String userAddress;

    @Column
    private String userCityName;

    @Column
    private  String userPinCode;

    @Column
    private  String userStateName;

    @Column
    private  String userGender;

    @Column
    private  int age;

    @Column
    private  String userAadharCardNumber;

    @Column
    private String userPanCardNumber;

    @Column
    private  String userMobileNumber;

    @OneToOne
    @JsonBackReference
    private  User user;
}
