package com.example.BookingApp.repository;

import com.example.BookingApp.entities.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationsRepository extends JpaRepository<RoomReservation, Long> {
}
