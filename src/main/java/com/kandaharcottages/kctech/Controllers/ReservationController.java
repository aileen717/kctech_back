package com.kandaharcottages.kctech.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kandaharcottages.kctech.Model.Reservation;
import com.kandaharcottages.kctech.NotFoundException.ReservationNotFoundException;
import com.kandaharcottages.kctech.Repository.ReservationRepository;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {


    ReservationRepository repo;

    public ReservationController(ReservationRepository repo){
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Reservation> getReservations() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            () -> new ReservationNotFoundException(id)
        );

    }

    @PostMapping("/new")
public String addReservation(@RequestBody Reservation newReservation) {
    boolean isAvailable = repo.isRoomAvailable(
        newReservation.getRoomId(),
        newReservation.getCheckInDate(),
        newReservation.getCheckOutDate()
    );
    
    if (!isAvailable) {
        return "The room is already reserved for the selected date(s).";
    }

    newReservation.setAvailable(true);
    newReservation.setStatus("pending"); 
    
    repo.save(newReservation); 
    
    return "A new reservation is created.";
}



    @DeleteMapping("/delete/{id}")
    public String deleteReservation (@PathVariable Long id){
        repo.deleteById(id);
        return "The reservation is deleted.";
    }

    @GetMapping("/check")
    public boolean checkRoomAvailability(
        @RequestParam Long roomId,
        @RequestParam LocalDate checkInDate,
        @RequestParam LocalDate checkOutDate) {
    
        return repo.isRoomAvailable(roomId, checkInDate, checkOutDate);
    }
    

    @PutMapping("/{id}")
    public Reservation updateReservationStatus(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        Reservation existingReservation = repo.findById(id).orElseThrow(
            () -> new ReservationNotFoundException(id)
        );
    
        String newStatus = updates.get("status");
        if (newStatus != null) {
            existingReservation.setStatus(newStatus);
        }
    
        return repo.save(existingReservation);
    }

    @GetMapping("/reservedDates")
    public List<ReservedDateRange> getReservedDates(@RequestParam Long roomId) {
        List<Reservation> reservations = repo.findByRoomId(roomId);
        List<ReservedDateRange> reservedDateRanges = new ArrayList<>();
        
        for (Reservation reservation : reservations) {
            reservedDateRanges.add(new ReservedDateRange(reservation.getCheckInDate(), reservation.getCheckOutDate()));
        }
        
        return reservedDateRanges;
    }
    public static class ReservedDateRange {
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
    
        public ReservedDateRange(LocalDate checkInDate, LocalDate checkOutDate) {
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
        }
    
        public LocalDate getCheckInDate() {
            return checkInDate;
        }
    
        public LocalDate getCheckOutDate() {
            return checkOutDate;
        }
    }
    
}