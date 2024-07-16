package com.kandaharcottages.kctech.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
    
    @Id
    @GeneratedValue
    private Long id;
    private Long userAuthId;
    private Long roomId;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private double total;
    private String status;



    public Reservation (){}



    public Reservation(Long userAuthId, Long roomId, LocalDate date, LocalTime checkIn, LocalTime checkOut, double total, String status) {
        this.userAuthId = userAuthId;
        this.roomId = roomId;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.total = total;
        this.status = status;
    }

    //getters
    public Long getId() {
        return id;
    }

    public Long getUserAuthId() {
        return userAuthId;
    }

    public Long roomId() {
        return roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public double getTotal() {
        return total;
    }
    public String getStatus() {
        return status;
    }

    //Setters
    public void setUserAuthId(Long userAuthId) {
        this.userAuthId = userAuthId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}