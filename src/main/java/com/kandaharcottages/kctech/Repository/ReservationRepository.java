package com.kandaharcottages.kctech.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Long>{

    // ISAHAN
    List<Reservation> findByRoomIdAndCheckInDate(Long roomId, LocalDate checkInDate);

    //  okok MARAMIHAN
    List<Reservation> findByRoomIdAndCheckInDateBetween(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);


















    


    //Query method to find reservations for a specific date and room
    List<Reservation> findByDateAndRoomId(LocalDate date, Long roomId);

    //Query method to find reservations for a date range and check if room is reserved
    boolean existsByDateBetweenAndRoomIdAndReservedIsTrue(LocalDate startDate, LocalDate endDate, Long roomId);

    // Find reservations by room ID and date range
    List<Reservation> findByRoomIdAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(
        Long roomId, LocalDate checkInDate, LocalDate checkOutDate);

    boolean existsByRoomIdAndCheckInDateAndReservedIsTrue(Long roomId, LocalDate checkInDate);
}

