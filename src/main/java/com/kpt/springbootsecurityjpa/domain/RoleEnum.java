package com.kpt.springbootsecurityjpa.domain;

public enum RoleEnum {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    private final String role;

    private RoleEnum(String role) {
        this.role = role;
    }
   
    public String getRole() {
        return role;
    }
}
