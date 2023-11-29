package com.bloodBank.bbms.bbmsbackend.repository;

import com.bloodBank.bbms.bbmsbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}