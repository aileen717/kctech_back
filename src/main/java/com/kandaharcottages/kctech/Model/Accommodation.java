package com.kandaharcottages.kctech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Accommodation {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String pax;
    private double price;
    private String status;
    private String url;

    public Accommodation (){}

    public Accommodation(String name, String type, String pax, double price, String status, String url) {
        this.name = name;
        this.type = type;
        this.pax = pax;
        this.price = price;
        this.status = status;
        this.url = url;
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

    public String getPax() {
        return pax;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPax(String pax) {
        this.pax = pax;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

}