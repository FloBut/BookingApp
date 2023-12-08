package com.example.BookingApp.repository;

import com.example.BookingApp.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    HotelRepository findAllByName(String name);

}
