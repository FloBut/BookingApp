package com.example.BookingApp.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class ReservationRequestDTO {

    private Set<Long> roomIds;
    private LocalDate checkIn;

    private LocalDate checkOut;

    private Long userId;

    public ReservationRequestDTO(Set<Long> roomIds, LocalDate checkIn, LocalDate checkOut, Long userId) {
        this.roomIds = roomIds;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.userId = userId;
    }

    public Set<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(Set<Long> roomIds) {
        this.roomIds = roomIds;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
