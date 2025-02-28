package com.banking.banking_server.Exception;

public class UserNotFoundException extends  Exception{
    public UserNotFoundException(String message){
         super(message);
    }
}
