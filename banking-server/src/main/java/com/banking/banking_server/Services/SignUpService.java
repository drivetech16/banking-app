package com.banking.banking_server.Services;

import com.banking.banking_server.Models.User;
import com.banking.banking_server.Request.ChangePasswordRequest;

import java.util.List;
import java.util.Optional;

public interface SignUpService {

    public User createUser(User user);

    public User findById(String userid);

    public User findByOtp(String otp);

    public  User findByEmail(String email);

    public  User findByResetPasswordToken(String resetpasswordtoken);

    public Optional<User> getUser(String userId);

    public List<User> getAllUser();

    public  boolean  checkEmail(String email);

    public Boolean changePassword(String userId, ChangePasswordRequest changePasswordRequest);

    public void  deleteUser(String email);

    public  void  SaveUser(User user);

    public  void updateIsEmailVerified(String otp);

    public  void updateResetPasswordToken(String  token , String email);

    public void  updatePassword(String token, String password);

    public void verifyEmailAndSendOtp(String email);
}
