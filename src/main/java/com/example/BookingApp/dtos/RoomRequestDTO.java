package com.example.BookingApp.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}