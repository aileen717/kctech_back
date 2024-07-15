package com.kandaharcottages.kctech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
    
    @Id
    @GeneratedValue
    private Long id;
    private Long userAuthId;
    private Long accommodationId;
    private String date;
    private String checkIn;
    private String checkOut;
    private double total;
    private String status;



    public Reservation (){}



    public Reservation(Long userAuthId, Long accommodationId, String date, String checkIn, String checkOut, double total, String status) {
        this.userAuthId = userAuthId;
        this.accommodationId = accommodationId;
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

    public Long getAccommodationId() {
        return accommodationId;
    }

    public String getDate() {
        return date;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
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

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}