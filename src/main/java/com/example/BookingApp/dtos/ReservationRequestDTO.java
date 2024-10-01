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
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
