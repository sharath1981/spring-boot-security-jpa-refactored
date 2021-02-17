package com.kpt.springbootsecurityjpa.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = -5980778859568720428L;
    
    private String userName;
    private String password;
    private boolean active;
    @Setter(AccessLevel.NONE)
    private Set<GrantedAuthority> authorities = new HashSet<>();

    public UserDetailsImpl(User user) {
        Optional.ofNullable(user).map(User::getUserName).ifPresent(this::setUserName);
        Optional.ofNullable(user).map(User::getPassword).ifPresent(this::setPassword);
        Optional.ofNullable(user).map(User::isActive).ifPresent(this::setActive);
        Optional.ofNullable(user)
                .map(User::getRoles)
                .map(Collection::stream)
                .orElse(Stream.empty())
                .map(Role::getName)
                .map(RoleEnum::name)
                .map(SimpleGrantedAuthority::new)
                .forEach(authorities::add);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
