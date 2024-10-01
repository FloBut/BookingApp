package com.example.BookingApp.service;

import com.example.BookingApp.dtos.ReservationRequestDTO;
import com.example.BookingApp.entities.Reservation;
import com.example.BookingApp.entities.Room;
import com.example.BookingApp.entities.RoomReservation;
import com.example.BookingApp.entities.User;
import com.example.BookingApp.exceptions.ResourceNotFoundException;
import com.example.BookingApp.repository.ReservationRepository;
import com.example.BookingApp.repository.RoomRepository;
import com.example.BookingApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private RoomService roomService;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.roomService = roomService;
    }


    public Reservation addReservation (ReservationRequestDTO reservationRequestDTO){
        User user = userRepository.findById(reservationRequestDTO.getUserId()).orElseThrow(()->new ResourceNotFoundException("User not found!"));
        List<Room> foundRooms = roomRepository.findAllById(reservationRequestDTO.getRoomIds());


        if (foundRooms.size() != reservationRequestDTO.getRoomIds().size()){
            throw  new ResourceNotFoundException("one or more rooms not found");
        }

        for (Room room: foundRooms){
            if (!roomService.isAvailable(room, reservationRequestDTO.getCheckIn(), reservationRequestDTO.getCheckOut())){
                throw  new ResourceNotFoundException("at least one of the rooms is already reserved");
            }
        }
        Reservation reservation = new Reservation();
        reservation.setCheckIn(reservationRequestDTO.getCheckIn());
        reservation.setCheckOut(reservationRequestDTO.getCheckOut());

        /*for (Room room: foundRooms) {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setReservation(reservation);
            roomReservation.setRoom(room);
            reservation.getRoomReservationsList().add(roomReservation);

        }*/

        List<RoomReservation> roomReservations = foundRooms.stream()
                .map(room -> mapFromRoomToRoomReservation(room,reservation))
                .collect(Collectors.toList());
        reservation.setRoomReservationsList(roomReservations);
        reservation.setUser(user);

        return reservationRepository.save(reservation);

    }

    public boolean existReservationBetween (Reservation reservation, LocalDate checkIn, LocalDate checkOut){
        return reservation.getCheckIn().isBefore(checkIn) && reservation.getCheckOut().isAfter(checkOut)
                || reservation.getCheckOut().isAfter(checkIn) && reservation.getCheckIn().isBefore(checkOut)
                || reservation.getCheckIn().isEqual(checkIn) || reservation.getCheckOut().isEqual(checkOut);
    }


    public RoomReservation mapFromRoomToRoomReservation (Room room, Reservation reservation){
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setReservation(reservation);
        roomReservation.setRoom(room);
        reservation.getRoomReservationsList().add(roomReservation);
        return roomReservation;
    }

    @Transactional
    public Optional<Double> getIncomeBy (LocalDate start, LocalDate end){
        List<Reservation> reservations = reservationRepository.findAllByCheckInAfterAndCheckOutBefore(start, end);
        return reservations.stream()
                .flatMap(reservation -> reservation.getRoomReservationsList().stream())
                .map(roomReservation -> roomReservation.getRoom().getPricePerNight())
                .reduce((sum, price)-> sum + price * getNumberOfNights(start, end));

        /*for (Reservation reservation: reservations){
            for (RoomReservation roomReservation: reservation.getRoomReservationsList()){
                totalPrice+= roomReservation.getRoom().getPricePerNight() * getNumberOfNights(start, end);
            }
        }*/
    }
    public Long getNumberOfNights(LocalDate start, LocalDate end){

        return ChronoUnit.DAYS.between(start, end);
    }


}