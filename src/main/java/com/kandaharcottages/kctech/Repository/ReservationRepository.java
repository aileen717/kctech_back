package com.kandaharcottages.kctech.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoomId(Long roomId);

    default boolean isRoomAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Reservation> reservations = findByRoomId(roomId);
        
        for (Reservation reservation : reservations) {
            LocalDate existingCheckInDate = reservation.getCheckInDate();
            LocalDate existingCheckOutDate = reservation.getCheckOutDate();
            
            boolean overlaps = checkInDate.isBefore(existingCheckOutDate) && existingCheckInDate.isBefore(checkOutDate);
            
            if (overlaps) {
                return false;
            }
        }
        
        return true;
    }
    

}