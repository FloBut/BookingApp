package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//un user poate fi si client si administrator
@Entity
//@Data // Lombok: Generates getters, setters, toString, equals, and hashCode
//@AllArgsConstructor // Lombok: Generates all-args constructor
//@NoArgsConstructor // Lombok: Generates no-args constructor
@Builder // Lombok: Allows usage of the builder pattern
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user",  cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("user-reservation")
    private List<Reservation> reservations;

    @Column
    private String name;

    @ManyToMany(mappedBy ="users",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference("users-roles")
    private Set<Role> roles;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.reservations = new ArrayList<>();
        this.roles = new HashSet<>();
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reservation> getReservations() {
        if(reservations==null){
            reservations = new ArrayList<>();
        }
        return reservations;
    }
}