package com.kandaharcottages.kctech.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoomId(Long roomId);

    default boolean isRoomReserved(Long roomId, LocalDate checkInDate, LocalTime checkInTime, 
                                   LocalDate checkOutDate, LocalTime checkOutTime) {
        List<Reservation> reservations = findByRoomId(roomId);
        
        for (Reservation reservation : reservations) {
            LocalDate existingCheckInDate = reservation.getCheckInDate();
            LocalTime existingCheckInTime = reservation.getCheckInTime();
            LocalDate existingCheckOutDate = reservation.getCheckOutDate();
            LocalTime existingCheckOutTime = reservation.getCheckOutTime();
            
            boolean startsBeforeEnds = checkInDate.isBefore(existingCheckOutDate) || 
                                        (checkInDate.isEqual(existingCheckOutDate) && checkInTime.isBefore(existingCheckOutTime));
            boolean endsAfterStarts = checkOutDate.isAfter(existingCheckInDate) || 
                                      (checkOutDate.isEqual(existingCheckInDate) && checkOutTime.isAfter(existingCheckInTime));
            if (startsBeforeEnds && endsAfterStarts) {
                return true;
            }
        }
        
        return false;
    }
}