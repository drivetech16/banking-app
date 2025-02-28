package com.banking.banking_server.Repository;

import com.banking.banking_server.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public  User findByEmail(String email);
    public  User findByResetPasswordToken(String ResetPasswordToken);
    public User findByotp(String otp);

    @Query(value = "select * from user_data where Userid=:userid", nativeQuery = true)
    public User getUserId(@Param("userid") String userid);

    @Transactional
    @Modifying
    @Query(value = "delete from user_data where email=:email", nativeQuery = true)
    public void  deleteuser(@Param("email") String email);
}
