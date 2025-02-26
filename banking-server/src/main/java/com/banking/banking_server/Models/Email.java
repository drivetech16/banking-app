package com.banking.banking_server.Models;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Email {
    public String email;
    public String subject;
    public String body;
    public Date emailSendDate;
}
