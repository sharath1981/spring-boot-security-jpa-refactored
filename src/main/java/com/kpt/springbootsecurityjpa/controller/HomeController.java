package com.kpt.springbootsecurityjpa.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public Principal home(Principal principal) {
        return principal;
    }

    @GetMapping("/admin")
    public Principal getAdmin(Principal principal) {
        return principal;
    }

    @GetMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }
}
