package com.banking.banking_server.Services.ServiceImplementation;

import com.banking.banking_server.Models.User;
import com.banking.banking_server.Repository.UserRepository;
import com.banking.banking_server.Request.ChangePasswordRequest;
import com.banking.banking_server.Services.SignUpService;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
import java.util.Optional;

public class SignUpServiceImplementation implements SignUpService {


    private UserRepository userRepository;

    private JavaMailSender javaMailSender;
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User findById(String userid) {
        return null;
    }

    @Override
    public User findByOtp(String otp) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByResetPasswordToken(String resetpasswordtoken) {
        return null;
    }

    @Override
    public Optional<User> getUser(String userId) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUser() {
        return List.of();
    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }

    @Override
    public Boolean changePassword(String userId, ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    @Override
    public void deleteUser(String email) {

    }

    @Override
    public void SaveUser(User user) {

    }

    @Override
    public void updateIsEmailVerified(String otp) {

    }

    @Override
    public void updateResetPasswordToken(String token, String email) {

    }

    @Override
    public void updatePassword(String token, String password) {

    }

    @Override
    public void verifyEmailAndSendOtp(String email) {

    }
}
