package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
@Builder
public class User {
    private int id;
    private String username;
    private String pwd;
    private String email;
    private String bankAccount;
    private Set<Role> userRoles;
}
