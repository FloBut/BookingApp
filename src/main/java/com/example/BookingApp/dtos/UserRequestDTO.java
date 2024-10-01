package com.example.BookingApp.dtos;

import com.example.BookingApp.entities.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private Long userId;
    private String name;
    private RoleType roleType;

}
