package com.banking.banking_server.Request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ChangePasswordRequest {
    private String oldPassword;
    private String newPassword;
}
