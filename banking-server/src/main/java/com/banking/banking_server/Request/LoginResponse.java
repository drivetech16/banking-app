package com.banking.banking_server.Request;

import com.banking.banking_server.Models.User;
import lombok.*;
import org.springframework.security.config.annotation.web.headers.HeadersSecurityMarker;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@HeadersSecurityMarker
public class LoginResponse {
    private String jwtToken;
    private User user;
}
