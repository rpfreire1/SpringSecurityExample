package com.gatinodev.springsecurity.repository;

import com.gatinodev.springsecurity.model.SecurityUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SecurityUserRepository extends MongoRepository<SecurityUser, String> {
    Optional<SecurityUser> findSecurityUserByUsername(String username);
}
