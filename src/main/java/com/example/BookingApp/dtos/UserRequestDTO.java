package com.example.BookingApp.dtos;

import com.example.BookingApp.entities.RoleType;

public class UserRequestDTO {
    private Long userId;
    private String name;
    private RoleType roleType;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, RoleType roleType) {
        this.name = name;
        this.roleType = roleType;
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRole(RoleType roleType) {
        this.roleType = roleType;
    }
}
