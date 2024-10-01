package com.example.BookingApp.controllers;

import com.example.BookingApp.dtos.ReservationRequestDTO;
import com.example.BookingApp.entities.Reservation;
import com.example.BookingApp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @PostMapping
    public ResponseEntity<Reservation> addReservation (@RequestBody ReservationRequestDTO reservationRequestDTO){
        return ResponseEntity.ok(reservationService.addReservation(reservationRequestDTO));
    }

}
