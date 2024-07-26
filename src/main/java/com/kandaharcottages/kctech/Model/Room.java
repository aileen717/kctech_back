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
    private String description;
    private double price;
    private String url;

    public Room (){}

    public Room(String name, String pax, String description, double price, String url) {
        this.name = name;
        this.pax = pax;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

}
