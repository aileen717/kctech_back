package com.kandaharcottages.kctech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Room {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String pax;
    private double price;
    private Boolean reserved; //true_reserved
    private String url;

    public Room (){}

    public Room(String name, String pax, double price, Boolean reserved, String url) {
        this.name = name;
        this.pax = pax;
        this.price = price;
        this.reserved = reserved;
        this.url = url;
    }

    //getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPax() {
        return pax;
    }

    public double getPrice() {
        return price;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public String getUrl() {
        return url;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPax(String pax) {
        this.pax = pax;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

}
