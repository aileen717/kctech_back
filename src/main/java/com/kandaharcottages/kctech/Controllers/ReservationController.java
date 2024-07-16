package com.kandaharcottages.kctech.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kandaharcottages.kctech.Model.Reservation;
import com.kandaharcottages.kctech.NotFoundException.ReservationNotFoundException;
import com.kandaharcottages.kctech.Repository.ReservationRepository;
import com.kandaharcottages.kctech.Service.ReservationService;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Endpoint to check if a room is reserved on a specific date
    @GetMapping("/room/{roomId}/date/{date}")
    public ResponseEntity<String> checkRoomReservationOnDate(
            @PathVariable Long roomId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        boolean reserved = reservationService.isRoomReservedOnDate(roomId, date);

        if (reserved) {
            return ResponseEntity.ok("Room is reserved on " + date.toString());
        } else {
            return ResponseEntity.ok("Room is available on " + date.toString());
        }
    }

    // Endpoint to check if a room is reserved within a date range
    @GetMapping("/room/{roomId}/daterange")
    public ResponseEntity<String> checkRoomReservationInDateRange(
            @PathVariable Long roomId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        boolean reserved = reservationService.isRoomReservedInDateRange(roomId, startDate, endDate);

        if (reserved) {
            return ResponseEntity.ok("Room is reserved within the date range");
        } else {
            return ResponseEntity.ok("Room is available within the date range");
        }
    }

    //ang nasa baba ay main

    ReservationRepository repo;

    public ReservationController(ReservationRepository repo){
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            () -> new ReservationNotFoundException(id)
        );

    }

    @PostMapping("/new")
    public String addReservation(@RequestBody Reservation newReservation){
        repo.save(newReservation);
        return "A new reservation is created.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservation (@PathVariable Long id){
        repo.deleteById(id);
        return "The reservation is deleted.";
    }
    
}
