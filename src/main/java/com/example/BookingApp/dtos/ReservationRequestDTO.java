package com.example.BookingApp.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class ReservationRequestDTO {
    @NotEmpty(message = "Room Ids can't not be empty")
    private Set<Long> roomIds;

    @NotNull(message = "Check - in date can't be null")
    @Future(message = "Check - in date must be in the future")
    private LocalDate checkIn;

    @NotNull(message = "Check-out date cannot be null")
    @Future(message = "Check-out date must be in the future")
    private LocalDate checkOut;

    @NotNull(message = "UserId can;t be null")
    private Long userId;

    public ReservationRequestDTO() {
    }

    public ReservationRequestDTO(Set<Long> roomIds, LocalDate checkIn, LocalDate checkOut, Long userId) {
        this.roomIds = roomIds;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.userId = userId;
    }


    public void setRoomIds(@NotEmpty(message = "Room Ids can't not be empty") Set<Long> roomIds) {
        this.roomIds = roomIds;
    }

    public void setCheckIn(@NotNull(message = "Check - in date can't be null") @Future(message = "Check - in date must be in the future") LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(@NotNull(message = "Check-out date cannot be null") @Future(message = "Check-out date must be in the future") LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setUserId(@NotNull(message = "UserId can;t be null") Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public Iterable<Long> getRoomIds() {
        return roomIds;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
