package com.kandaharcottages.kctech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
    
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long accommodationId;
    private String date;
    private String checkIn;
    private String checkOut;
    private int guest;
    private double total;



    public Reservation (){}



    public Reservation(Long userId, Long accommodationId, String date, String checkIn, String checkOut, int guest,
            double total) {
        this.userId = userId;
        this.accommodationId = accommodationId;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guest = guest;
        this.total = total;
    }

    //getters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
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

    public int getGuest() {
        return guest;
    }

    public double getTotal() {
        return total;
    }

    //Setters
    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}