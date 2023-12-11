package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class RoomRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long reservationNo;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    @JsonBackReference("roomRes - reservation")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "roomRes_id")
    @JsonBackReference("roomRes - room")
    private Room room;

    public RoomRes() {
    }

    public RoomRes(Long reservationNo) {
        this.reservationNo = reservationNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Long reservationNo) {
        this.reservationNo = reservationNo;
    }


    @Override
    public String toString() {
        return "RoomRes{" +
                "id=" + id +
                ", reservationNo=" + reservationNo +
                '}';
    }
}
