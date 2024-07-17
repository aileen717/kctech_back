package com.kandaharcottages.kctech.Controllers;

import java.time.LocalDate;
import java.util.List;



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
    public String addReservation(@RequestBody Reservation newReservation){
        repo.save(newReservation);
        return "A new reservation is created.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservation (@PathVariable Long id){
        repo.deleteById(id);
        return "The reservation is deleted.";
    }

    @GetMapping("/check")
    public boolean checkRoomReservation(
            @RequestParam Long roomId,
            @RequestParam LocalDate checkInDate,
            @RequestParam LocalDate checkOutDate) {
        return repo.isRoomReserved(roomId, checkInDate, null, checkOutDate, null);
    }
    
}