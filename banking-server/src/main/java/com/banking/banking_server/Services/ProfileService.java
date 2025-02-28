package com.banking.banking_server.Services;

import com.banking.banking_server.Exception.UserNotFoundException;
import com.banking.banking_server.Models.CustomUserDetails;
import com.banking.banking_server.Models.User;

public interface ProfileService {
    public User createUserProfile(CustomUserDetails customUserDetails, String  userId) throws UserNotFoundException;

    public  User updateUserProfile(CustomUserDetails customUserDetails , String userId) throws  UserNotFoundException;
}
