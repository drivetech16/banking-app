package com.banking.banking_server.Request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class LoginRequest {
    private  String email;
    private  String password;
}
