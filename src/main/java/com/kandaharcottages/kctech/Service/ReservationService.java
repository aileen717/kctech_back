package com.kandaharcottages.kctech.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kandaharcottages.kctech.Model.Reservation;
import com.kandaharcottages.kctech.Repository.ReservationRepository;

public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //  ISAHAN
    public boolean isRoomReservedOnDate(Long roomId, LocalDate checkInDate) {
        return reservationRepository.existsByRoomIdAndCheckInDateAndReservedIsTrue(roomId, checkInDate);
    }


    // MARAMIHAN
    public boolean isRoomReservedInDateRange(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Reservation> reservations = reservationRepository.findByRoomIdAndCheckInDateBetween(roomId, checkInDate, checkOutDate);
        return !reservations.isEmpty();
    }



























    public List<Reservation> findReservationsByRoomAndDateRange(Long roomId, LocalDate startDate, LocalDate endDate) {
        return reservationRepository.findByRoomIdAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(roomId, startDate, endDate);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

}
