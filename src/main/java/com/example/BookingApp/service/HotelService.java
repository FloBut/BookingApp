package com.example.BookingApp.service;

import com.example.BookingApp.dtos.RoomRequestDTO;
import com.example.BookingApp.entities.Hotel;
import com.example.BookingApp.entities.Room;
import com.example.BookingApp.exceptions.ResourceNotFoundException;
import com.example.BookingApp.repository.HotelRepository;
import com.example.BookingApp.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {


    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public Hotel createHotel(String hotelName){
        Hotel hotel = new Hotel();
        return hotelRepository.save(hotel);

    }

    @Transactional
    public Room addRoomToHotel(RoomRequestDTO roomRequestDTO, Long hotelId){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel does not exist!"));
        Room room = new Room();
        return roomRepository.save(room);
    }
}
