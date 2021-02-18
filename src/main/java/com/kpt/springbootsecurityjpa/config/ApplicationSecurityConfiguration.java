package com.kpt.springbootsecurityjpa.config;

import com.kpt.springbootsecurityjpa.repository.UserRepository;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username->userRepository.findByUsername(username)
                                                        .orElseThrow(()->new UsernameNotFoundException(String.format("%s doesn't exists...", username)))
        ).passwordEncoder(NoOpPasswordEncoder.getInstance());

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin").hasAuthority("ADMIN")
            .antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/").permitAll()
            .and().formLogin();
    }
}
