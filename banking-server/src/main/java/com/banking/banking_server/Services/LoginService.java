package com.banking.banking_server.Services;

import com.banking.banking_server.Exception.UserNotFoundException;
import com.banking.banking_server.Models.User;
import com.banking.banking_server.Request.LoginRequest;

public interface LoginService {
    public User findByEmail(LoginRequest loginRequest) throws UserNotFoundException;
}
