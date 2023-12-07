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
    private RoomRes roomRes1;

    @ManyToOne
    @JoinColumn(name = "roomRes_id")
    @JsonBackReference("roomRes - room")
    private RoomRes roomRes2;

    public RoomRes() {
    }

    public RoomRes(Long id, Long reservationNo, RoomRes roomRes1, RoomRes roomRes2) {
        this.id = id;
        this.reservationNo = reservationNo;
        this.roomRes1 = roomRes1;
        this.roomRes2 = roomRes2;
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

    public RoomRes getRoomRes1() {
        return roomRes1;
    }

    public void setRoomRes1(RoomRes roomRes1) {
        this.roomRes1 = roomRes1;
    }

    public RoomRes getRoomRes2() {
        return roomRes2;
    }

    public void setRoomRes2(RoomRes roomRes2) {
        this.roomRes2 = roomRes2;
    }

    @Override
    public String toString() {
        return "RoomRes{" +
                "id=" + id +
                ", reservationNo=" + reservationNo +
                ", roomRes1=" + roomRes1 +
                ", roomRes2=" + roomRes2 +
                '}';
    }
}
