package com.example.BookingApp.repository;

import com.example.BookingApp.entities.Role;
import com.example.BookingApp.entities.RoleType;
import com.example.BookingApp.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
