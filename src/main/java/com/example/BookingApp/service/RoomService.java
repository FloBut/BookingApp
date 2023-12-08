package com.example.BookingApp.service;
//adaug o camera in lista de camere a hotelului in calitate de admin

import com.example.BookingApp.dtos.RoomRequestDTO;
import com.example.BookingApp.entities.Hotel;
import com.example.BookingApp.entities.Room;
import com.example.BookingApp.repository.HotelRepository;
import com.example.BookingApp.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public Room addRoomToHotel(RoomRequestDTO roomRequestDTO) {
        //caut in baza de date numele hotelului si lista lui de camere adaug camera
        Hotel hotelFoundedInDataBase = hotelRepository.findAllByName(roomRequestDTO.getHotelName());
        Room roomToBeSaved = new Room();
        roomToBeSaved.setRoomNo(roomRequestDTO.getRoomNo());
        roomToBeSaved.setAvailability(roomRequestDTO.getAvailability());
        roomToBeSaved.setId(roomRequestDTO.getId());
        roomToBeSaved.setPrice(roomRequestDTO.getPrice());
        roomToBeSaved.setHotel(hotelFoundedInDataBase);
        return roomRepository.save(roomToBeSaved);



    }
}
