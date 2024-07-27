package com.kandaharcottages.kctech.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kandaharcottages.kctech.Model.Reservation;
import com.kandaharcottages.kctech.Model.Room;
import com.kandaharcottages.kctech.NotFoundException.ReservationNotFoundException;
import com.kandaharcottages.kctech.Repository.ReservationRepository;
import com.kandaharcottages.kctech.Repository.RoomRepository;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {


    ReservationRepository repo;
    RoomRepository roomRepo;

    public ReservationController(ReservationRepository repo, RoomRepository roomRepo){
        this.repo = repo;
        this.roomRepo = roomRepo;
        // updateReservationStatusAutomatically();
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

        Room room = roomRepo.findById(newReservation.getRoomId())
            .orElseThrow(() -> new RuntimeException("Room not found"));

        newReservation.computeTotal(room.getPrice());
        newReservation.setStatus("Pending");
        repo.save(newReservation);

        return "A new reservation is created.";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteReservation (@PathVariable Long id){
        repo.deleteById(id);
        return "The reservation is deleted.";
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
    
    // private void updateReservationStatusAutomatically() {
    //     List<Reservation> reservations = repo.findAll();
    //     LocalDate today = LocalDate.now();
    //     LocalTime now = LocalTime.now();

    //     for (Reservation reservation : reservations) {
    //         LocalDate checkOutDate = reservation.getCheckOutDate();
    //         LocalTime checkOutTime = reservation.getCheckOutTime();

           
    //         if ((checkOutDate.isBefore(today) || (checkOutDate.isEqual(today) && checkOutTime.isBefore(now))) &&
    //             "pending".equals(reservation.getStatus())) {
    //             reservation.setStatus("Completed");
    //             repo.save(reservation);
    //             }
    //         }
    //     }
}
