package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String roomNo;
    @Column
    private Availability availability;
    @Column
    private double price;
    @OneToMany
    @JsonManagedReference("roomRes - room")
    private List<RoomRes> ReservationList;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference("hotel - room")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "roomRes_id")
    @JsonBackReference("roomRes - room")
    private RoomRes roomRes;

    public Room() {
    }

    public Room(Long id, String roomNo, Availability availability, double price, List<RoomRes> ReservationList, Hotel hotel, RoomRes roomRes) {
        this.id = id;
        this.roomNo = roomNo;
        this.availability = availability;
        this.price = price;
        this.ReservationList = ReservationList;
        this.hotel = hotel;
        this.roomRes = roomRes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<RoomRes> getReservationList() {
        return ReservationList;
    }

    public void setReservationList(List<RoomRes> roomResList) {
        this.ReservationList = roomResList;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomRes getRoomRes() {
        return roomRes;
    }

    public void setRoomRes(RoomRes roomRes) {
        this.roomRes = roomRes;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNo='" + roomNo + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                ", roomResList=" + ReservationList +
                ", hotel=" + hotel +
                ", roomRes=" + roomRes +
                '}';
    }
}
