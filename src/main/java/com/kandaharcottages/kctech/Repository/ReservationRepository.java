package com.kandaharcottages.kctech.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Long>{

    List<Reservation> findByRoomIdAndCheckInDate(Long roomId, LocalDate checkInDate);
    List<Reservation> findByRoomIdAndCheckInDateBetween(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);

    default boolean isRoomReserved(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        boolean reservedOnDate = !findByRoomIdAndCheckInDate(roomId, checkInDate).isEmpty();
        boolean reservedInRange = !findByRoomIdAndCheckInDateBetween(roomId, checkInDate, checkOutDate).isEmpty();
        return reservedOnDate || reservedInRange;
    } 
}