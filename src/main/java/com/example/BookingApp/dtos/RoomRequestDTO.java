package com.example.BookingApp.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class RoomRequestDTO {

    @NotNull(message = "Id can't not be null")
    private Long id;

    @NotNull
    @Min(1)
    private Long roomNumber;

    @NotNull
    @Min(0)
    private Double pricePerNight;

    @NotNull
    @Min(1)
    private Integer guestNumber;

    @NotNull
    private Long HotelId;

    public RoomRequestDTO() {
    }

    public RoomRequestDTO(Long id, Long roomNumber, Double pricePerNight, Integer guestNumber, Long hotelId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.guestNumber = guestNumber;
        HotelId = hotelId;
    }

    public @NotNull(message = "Id can't not be null") Long getId() {
        return id;
    }

    public void setId(@NotNull(message = "Id can't not be null") Long id) {
        this.id = id;
    }

    public @NotNull Long getHotelId() {
        return HotelId;
    }

    public void setHotelId(@NotNull Long hotelId) {
        HotelId = hotelId;
    }

    public void setGuestNumber(@NotNull @Min(1) Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public void setPricePerNight(@NotNull @Min(0) Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setRoomNumber(@NotNull @Min(1) Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Object getRoomNumber() {
        return roomNumber;
    }

    public Object getPricePerNight() {
        return pricePerNight;
    }

    public Object getGuestNumber() {
        return guestNumber;
    }
}