package com.kandaharcottages.kctech.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kandaharcottages.kctech.Model.UserDetails;
import com.kandaharcottages.kctech.NotFoundException.UserDetailsNotFoundException;
import com.kandaharcottages.kctech.Repository.UserDetailsRepository;

@RestController
@RequestMapping("/api/v1/userDetails")
public class UserDetailsController {

    UserDetailsRepository repo;

    public UserDetailsController(UserDetailsRepository repo){
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<UserDetails> getUserDetails(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public UserDetails getUserDetails(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            () -> new UserDetailsNotFoundException(id)
        );

    }

    @PostMapping("/new")
    public String addUserDetails(@RequestBody UserDetails newUserDetails){
        repo.save(newUserDetails);
        return "A new user is created.";
    }

    @PutMapping("/{id}")
    public UserDetails updateUserDetails(@PathVariable Long id, @RequestBody UserDetails newUserDetails){
        return repo.findById(id)
        .map(userDetails -> {
            userDetails.setName(newUserDetails.getName());
            userDetails.setAddress(newUserDetails.getAddress());
            userDetails.setContact(newUserDetails.getContact());
            userDetails.setUserAuthId(newUserDetails.getUserAuthId());
            return repo.save(userDetails);
        }).orElseGet(() -> {
            return repo.save(newUserDetails);
        });

    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserDetails (@PathVariable Long id){
        repo.deleteById(id);
        return "The user is deleted.";
    }
    
}
