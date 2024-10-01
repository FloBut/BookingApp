package com.example.BookingApp.service;
//adaug o camera in lista de camere a hotelului in calitate de admin

import com.example.BookingApp.dtos.RoomRequestDTO;
import com.example.BookingApp.entities.Hotel;
import com.example.BookingApp.entities.Room;
import com.example.BookingApp.exceptions.ResourceNotFoundException;
import com.example.BookingApp.repository.HotelRepository;
import com.example.BookingApp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    RoomRepository roomRepository;

    ReservationService reservationService;
    @Autowired
    public RoomService(RoomRepository roomRepository, ReservationService reservationService) {
        this.roomRepository = roomRepository;
        this.reservationService = reservationService;
    }

    public List<Room> getAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut, Integer numberOfPersons){
        List<Room> foundRooms = roomRepository.findAllByGuestNumber(numberOfPersons);
        return foundRooms.stream()
                .filter(room -> isAvailable(room, checkIn, checkOut))
                .collect(Collectors.toList());
    }

    public boolean isAvailable(Room room, LocalDate checkIn , LocalDate checkOut){
        return room.getRoomReservationsList().stream()
                .map(roomReservation -> roomReservation.getReservation())
                .noneMatch(reservation -> reservationService.existReservationBetween(reservation,checkIn,checkOut));
    }

    public List<Room> getAvailableRoomsByPrice(LocalDate checkIn, LocalDate checkOut, Integer numberOfPersons){
        List<Room> availableRooms = getAvailableRoomsBy(checkIn, checkOut, numberOfPersons);
        return availableRooms.stream()
                .sorted((r1,r2) -> Double.compare(r1.getPricePerNight(), r2.getPricePerNight()))
                .collect(Collectors.toList());
    }
}
