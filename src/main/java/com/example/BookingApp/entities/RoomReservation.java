package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
//@Data // Lombok: Generates getters, setters, toString, equals, and hashCode
//@AllArgsConstructor // Lombok: Generates all-args constructor
//@NoArgsConstructor // Lombok: Generates no-args constructor
@Builder // Lombok: Allows usage of the builder pattern

public class RoomReservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference("roomreserv-room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    @JsonIgnore
    private Reservation reservation;

    public RoomReservation() {
    }

    public RoomReservation(Long id, Room room, Reservation reservation) {
        this.id = id;
        this.room = room;
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
