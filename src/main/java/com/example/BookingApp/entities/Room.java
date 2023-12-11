package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String roomNo;
    @Enumerated(EnumType.STRING)
    @Column
    private Availability availability;
    @Column
    private double price;
    @Column
    private Long noPersonsInRoom;
    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("roomRes - room")
    private List<RoomRes> roomRes2;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference("hotel - room")
    private Hotel hotel;

    public Room() {
    }

    public Room(String roomNo, Availability availability, double price, Long noPersonsInRoom) {
        this.roomNo = roomNo;
        this.availability = availability;
        this.price = price;
        this.noPersonsInRoom = noPersonsInRoom;
        this.roomRes2 = new ArrayList<>();
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

    public Long getNoPersonsInRoom() {
        return noPersonsInRoom;
    }

    public void setNoPersonsInRoom(Long noPersonsInRoom) {
        this.noPersonsInRoom = noPersonsInRoom;
    }

    public List<RoomRes> getReservationList() {
        return roomRes2;
    }

    public void setReservationList(List<RoomRes> roomResList) {
        this.roomRes2 = roomResList;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<RoomRes> getRoomRes() {
        return roomRes2;
    }

    public void setRoomRes(List<RoomRes> roomRes) {

        this.roomRes2 = roomRes;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNo='" + roomNo + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                ", roomResList=" + roomRes2 +
                ", hotel=" + hotel +
                ", roomRes2=" + roomRes2 +
                '}';
    }
}
