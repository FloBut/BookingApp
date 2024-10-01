package com.example.BookingApp.repository;

import com.example.BookingApp.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByGuestNumber(Integer numberOfPersons);

}
