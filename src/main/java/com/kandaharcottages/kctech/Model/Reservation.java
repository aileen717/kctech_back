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
    private LocalDate checkInDate;
    private LocalTime checkInTime;
    private LocalDate checkOutDate;
    private LocalTime checkOutTime;;
    private double total;
    private Boolean reserved  = true;
    private String status = "pending";



    public Reservation (){}



    public Reservation(Long userAuthId, Long roomId, LocalDate checkInDate, LocalTime checkInTime, LocalDate checkOutDate, 
    LocalTime checkOutTime, double total, Boolean reserved, String status) {

        this.userAuthId = userAuthId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
        this.total = total;
        this.reserved = reserved;
        this.status = status;
    }

    //getters
    public Long getId() {
        return id;
    }

    public Long getUserAuthId() {
        return userAuthId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public double getTotal() {
        return total;
    }
    public Boolean getReserved() {
        return reserved;
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

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}