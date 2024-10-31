package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
//@Data // generates getter, setter, to string, equals(), hashCode() (the same hash code if two objects are equals)
//@NoArgsConstructor
//@AllArgsConstructor
@Builder //permit tu use builder pattern to create Role
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role type can not be null")
    private RoleType roleType;

    @ManyToMany
    @JoinTable(
            name = "user-role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    @JsonBackReference("users-roles")
    @Builder.Default
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
        user.getRoles().add(this);
    }
    public void removeUser(User user) {
        users.remove(user);
        user.getRoles().remove(this);
    }

    public Role() {
    }

    public Role(Long id, Set<User> users, RoleType roleType) {
        this.id = id;
        this.users = users;
        this.roleType = roleType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public @NotNull(message = "Role type can not be null") RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(@NotNull(message = "Role type can not be null") RoleType roleType) {
        this.roleType = roleType;
    }
}