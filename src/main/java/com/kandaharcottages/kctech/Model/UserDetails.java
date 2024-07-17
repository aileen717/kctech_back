package com.kandaharcottages.kctech.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String contact;
    private Long userAuthId;

public UserDetails(){}


    public UserDetails(Long userAuthId, String name, String address, String contact) {
        this.userAuthId = userAuthId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    //getters
    public Long getId() {
        return id;
    }

    public Long getUserAuthId() {
        return userAuthId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }


    //setters
    public void setUserAuthId(Long userAuthId) {
        this.userAuthId = userAuthId;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public void setContact(String contact) {
        this.contact = contact;
    }

    
        
}
