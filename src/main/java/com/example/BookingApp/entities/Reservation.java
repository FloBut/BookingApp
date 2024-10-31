package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data // Lombok: Generates getters, setters, toString, equals, and hashCode
//@AllArgsConstructor // Lombok: Generates all-args constructor
//@NoArgsConstructor // Lombok: Generates no-args constructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Check-in date cannot be null")
    @FutureOrPresent(message = "Check-in date must be in the present or future")
    private LocalDate checkIn;

    @Column(nullable = false)
    @NotNull(message = "Check-out date cannot be null")
    @FutureOrPresent(message = "Check-out date must be in the present or future")
    private LocalDate checkOut;

    @OneToMany(mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("reservation-roomreservation")
    @Builder.Default
    private List<RoomReservation> roomReservationList = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Reservation must be associated with a user")
    @JsonBackReference("user-reservation")
    private User user;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Check-in date cannot be null") @FutureOrPresent(message = "Check-in date must be in the present or future") LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(@NotNull(message = "Check-in date cannot be null") @FutureOrPresent(message = "Check-in date must be in the present or future") LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public @NotNull(message = "Check-out date cannot be null") @FutureOrPresent(message = "Check-out date must be in the present or future") LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(@NotNull(message = "Check-out date cannot be null") @FutureOrPresent(message = "Check-out date must be in the present or future") LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public List<RoomReservation> getRoomReservationList() {
        return roomReservationList;
    }

    public void setRoomReservationList(List<RoomReservation> roomReservationList) {
        this.roomReservationList = roomReservationList;
    }

    public @NotNull(message = "Reservation must be associated with a user") User getUser() {
        return user;
    }

    public void setUser(@NotNull(message = "Reservation must be associated with a user") User user) {
        this.user = user;
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

    // Helper methods to manage the bidirectional relationship
    public void addRoomReservation(RoomReservation roomReservation) {
        roomReservation.setReservation(this);
        roomReservationList.add(roomReservation);
    }

    public void removeRoomReservation(RoomReservation roomReservation) {
        roomReservation.setReservation(null);
        roomReservationList.remove(roomReservation);
    }
}