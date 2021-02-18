package com.kpt.springbootsecurityjpa.repository;

import java.util.Optional;

import com.kpt.springbootsecurityjpa.model.User;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"authorities"}) 
    Optional<User> findByUsername(String username);
}
