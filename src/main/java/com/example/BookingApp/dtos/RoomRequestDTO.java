package com.example.BookingApp.dtos;

import com.example.BookingApp.entities.Availability;

public class RoomRequestDTO {
    private Long id;
    private String roomNo;
    private Availability availability;
    private double price;
    private String hotelName;

    public RoomRequestDTO(Long id, String roomNo, Availability availability, double price, String hotelName) {
        this.id = id;
        this.roomNo = roomNo;
        this.availability = availability;
        this.price = price;
        this.hotelName = hotelName;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
