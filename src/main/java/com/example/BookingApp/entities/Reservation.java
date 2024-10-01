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
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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