package com.kandaharcottages.kctech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String password;

    public User (){}

    public User(String name, String address, String contact, String email, String password){
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
    }

    //getters
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }
    
    public String getContact(){
        return contact;
    }
    
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

}

