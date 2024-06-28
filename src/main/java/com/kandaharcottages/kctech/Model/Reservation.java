package com.kandaharcottages.kctech.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private Date date;
    private Date checkIn;
    private Date checkOut;
    private int guest;
    private double total;



    public Reservation (){}

    
    public Reservation(String name, String type, Date date, Date checkIn, Date checkOut, int guest, double total) {
        this.name = name;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public int getGuest() {
        return guest;
    }

    public double getTotal() {
        return total;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}