package com.banking.banking_server.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user_data")
public class User implements  UserDetails
{
    @Id
    @Column(name = "user_id")
    private String Userid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    public  Role role;

    @Column(name = "accountOpeneingRequired")
    private boolean accountOpeneingRequired=false;

    private boolean accountlocked=false;
    private boolean accountenanled=true;

    @Column(name = "accountEmailVerified")
    private boolean accountEmailVerified;

    @Column(name = "accountCreatedDate")
    private Date accountCreatedDate;

    @Column(name = "resetPasswordToken")
    private String resetPasswordToken;

    @Column(name="otp")
    public String otp;

    @Column(name = "imageName")
    private String imageName;

    @Transient
    public  String token ;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private CustomUserDetails customUserDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="", referencedColumnName ="user_id")
    private List<BankAccount> bankAccountList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "" , referencedColumnName = "user_id")
    private List<Beneficiaries> beneficiariesList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority=new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
