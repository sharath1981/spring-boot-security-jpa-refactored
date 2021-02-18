package com.kpt.springbootsecurityjpa.service;

import com.kpt.springbootsecurityjpa.model.User;
import com.kpt.springbootsecurityjpa.repository.UserRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("%s doesn't exists...", username)));
    }
}
