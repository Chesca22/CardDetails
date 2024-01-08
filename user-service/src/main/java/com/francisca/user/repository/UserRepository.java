package com.francisca.user.repository;

import com.francisca.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
}
