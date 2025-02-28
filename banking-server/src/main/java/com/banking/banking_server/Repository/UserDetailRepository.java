package com.banking.banking_server.Repository;

import com.banking.banking_server.Models.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<CustomUserDetails,Integer> {
}
