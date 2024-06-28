package com.kandaharcottages.kctech.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kandaharcottages.kctech.Model.Reservation;
import com.kandaharcottages.kctech.NotFoundException.ReservationNotFoundException;
import com.kandaharcottages.kctech.Repository.ReservationRepository;

@RestController
public class ReservationController {

    ReservationRepository repo;

    public ReservationController(ReservationRepository repo){
        this.repo = repo;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){
        return repo.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            () -> new ReservationNotFoundException(id)
        );

    }

    @PostMapping("/reservations/new")
    public String addReservation(@RequestBody Reservation newReservation){
        repo.save(newReservation);
        return "A new reservation is created.";
    }

    @PutMapping("/reservations/edit/{id}")
    public Reservation updateUser(@PathVariable Long id, @RequestBody Reservation newReservation){
        return repo.findById(id)
        .map(reservation -> {
            reservation.setName(newReservation.getName());
            reservation.setType(newReservation.getType());
            reservation.setDate(newReservation.getDate());
            reservation.setCheckIn(newReservation.getCheckIn());
            reservation.setCheckOut(newReservation.getCheckOut());
            reservation.setGuest(newReservation.getGuest());
            reservation.setTotal(newReservation.getTotal());
            return repo.save(reservation);
        }).orElseGet(() -> {
            return repo.save(newReservation);
        });

    }

    @DeleteMapping("/reservations/delete/{id}")
    public String deleteUser (@PathVariable Long id){
        repo.deleteById(id);
        return "The reservation is deleted.";
    }
    
}
