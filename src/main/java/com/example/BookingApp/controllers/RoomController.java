package com.example.BookingApp.controllers;

import com.example.BookingApp.dtos.RoomRequestDTO;
import com.example.BookingApp.entities.Room;
import com.example.BookingApp.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @PostMapping
    public ResponseEntity<Room>addRoom(@RequestBody RoomRequestDTO roomRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addRoomToHotel(roomRequestDTO));
    }


}
