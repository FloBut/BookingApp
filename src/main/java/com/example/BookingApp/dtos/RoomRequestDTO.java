package com.example.BookingApp.dtos;

import com.example.BookingApp.entities.Availability;

public class RoomRequestDTO {

    private Long id;

    private Long roomNumber;

    private Double pricePerNight;

    private Integer guestNumber;

    // private Long hotelId;

    public RoomRequestDTO(Long id, Long roomNumber, Double pricePerNight, Integer guestNumber) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.guestNumber = guestNumber;
        // this.hotelId = hotelId;
    }

    public RoomRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

//    public Long getHotelId() {
//        return hotelId;
//    }
//
//    public void setHotelId(Long hotelId) {
//        this.hotelId = hotelId;
//    }
}