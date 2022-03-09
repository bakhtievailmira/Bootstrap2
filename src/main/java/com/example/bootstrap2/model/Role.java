package com.example.bootstrap2.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;


public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

    public List<String> getList() {
        List<String> list = new ArrayList<>();
        for (Role role : Role.values()) {
            list.add(role.name());
        }
        return list;
    }
}