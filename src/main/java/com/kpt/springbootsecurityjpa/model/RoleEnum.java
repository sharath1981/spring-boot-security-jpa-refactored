package com.kpt.springbootsecurityjpa.model;

public enum RoleEnum {
    ROLE_ADMIN(RoleEnum.ADMIN), 
    ROLE_USER(RoleEnum.USER);

    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";

    private final String role;

    private RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
