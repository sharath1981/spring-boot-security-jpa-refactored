package com.kpt.springbootsecurityjpa.config;

import static com.kpt.springbootsecurityjpa.model.RoleEnum.ROLE_ADMIN;
import static com.kpt.springbootsecurityjpa.model.RoleEnum.ROLE_USER;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin").hasAuthority(ROLE_ADMIN.name())
            .antMatchers("/user").hasAnyAuthority(ROLE_USER.name(), ROLE_ADMIN.name())
            .antMatchers("/").permitAll()
            .and().formLogin();
    }
}
