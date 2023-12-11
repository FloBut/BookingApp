package com.example.BookingApp.service;
//adaug o camera in lista de camere a hotelului in calitate de admin

import com.example.BookingApp.dtos.RoomRequestDTO;
import com.example.BookingApp.entities.Hotel;
import com.example.BookingApp.entities.Room;
import com.example.BookingApp.exceptions.ResourceNotFoundException;
import org.springframework.web.server.ResponseStatusException;
import com.example.BookingApp.repository.HotelRepository;
import com.example.BookingApp.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.function.*;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }
@Transactional
    public Room addRoomToHotel(RoomRequestDTO roomRequestDTO) {
        //caut in baza de date numele hotelului si in lista lui de camere adaug camera
    Hotel hotelFoundedInDataBase = hotelRepository.findById(roomRequestDTO.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
        Room roomToBeSaved = new Room();
        roomToBeSaved.setRoomNo(roomRequestDTO.getRoomNo());
        roomToBeSaved.setAvailability(roomRequestDTO.getAvailability());
        roomToBeSaved.setPrice(roomRequestDTO.getPrice());
        roomToBeSaved.setHotel(hotelFoundedInDataBase);
        return roomRepository.save(roomToBeSaved);
    }
}
