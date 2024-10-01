package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data // generates getter, setter, to string, equals(), hashCode() (the same hash code if two objects are equals)
@NoArgsConstructor
@AllArgsConstructor
@Builder //permit tu use builder pattern to create Role
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Room no can't be null")
    @Min(value = 1, message = "Room number must be greater then 1")
    private Long roomNumber;

    @Column
    @NotNull(message = "Price per night can't be null")
    @Positive(message = "Price per night must be a positive number")
    private Double pricePerNight;


    @Column(nullable = false)
    @NotNull(message = "Guest number cannot be null")
    @Min(value = 1, message = "Guest number must be at least 1")
    private Integer guestNumber;

    @OneToMany(mappedBy = "room",  cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("roomreserv-room")
    @Builder.Default
    List<RoomReservation> roomReservationList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference("hotel-room")
    private Hotel hotel;

    @Column
    @Enumerated(EnumType.STRING)
    private Availability availability;


    public Room(Long roomNumber, Double pricePerNight, Integer guestNumber, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.guestNumber = guestNumber;
        this.hotel = hotel;
        roomReservationList = new ArrayList<>();
    }


}