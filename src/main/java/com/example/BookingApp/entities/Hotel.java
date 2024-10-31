package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data // Lombok: Generates getters, setters, toString, equals, and hashCode
//@AllArgsConstructor // Lombok: Generates all-args constructor
//@NoArgsConstructor // Lombok: Generates no-args constructor
@Builder // Lombok: Allows usage of the builder pattern
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Hotel name cannot be null")
    @Size(min = 1, max = 100, message = "Hotel name must be between 1 and 100 characters")
    private String name;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference("hotel-room")
    @Builder.Default // Lombok: Ensure rooms is initialized when using @Builder
    private List<Room> rooms = new ArrayList<>();

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Helper methods for bidirectional relationship management
    public void addRoom(@NotNull Room room) {
       //room.setHotel(this);
        rooms.add(room);
    }

//    public void removeRoom(Room room) {
//       room.setHotel(null);
//        rooms.remove(room);
//    }

    public Hotel() {
    }

    public Hotel(Long id, String name, List<Room> rooms, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.rooms = rooms;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Hotel name cannot be null") @Size(min = 1, max = 100, message = "Hotel name must be between 1 and 100 characters") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Hotel name cannot be null") @Size(min = 1, max = 100, message = "Hotel name must be between 1 and 100 characters") String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}