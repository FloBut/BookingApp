package com.example.BookingApp.dtos;

import com.example.BookingApp.entities.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class UserRequestDTO {
    private Long userId;
    private String name;
    private RoleType roleType;

    public UserRequestDTO() {
    }

    public UserRequestDTO(Long userId, String name, RoleType roleType) {
        this.userId = userId;
        this.name = name;
        this.roleType = roleType;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
