package com.zono.chefshug.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // getters and setters for all fields
}
