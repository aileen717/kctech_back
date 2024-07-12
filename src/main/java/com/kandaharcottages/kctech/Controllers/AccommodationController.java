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

import com.kandaharcottages.kctech.Model.Accommodation;
import com.kandaharcottages.kctech.NotFoundException.AccommodationNotFoundException;
import com.kandaharcottages.kctech.Repository.AccommodationRepository;

@RestController
@RequestMapping("/api/v1/accommodation")
public class AccommodationController {

    AccommodationRepository repo;

    public AccommodationController(AccommodationRepository repo){
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Accommodation> getAccommodations(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Accommodation getAccommodation(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            () -> new AccommodationNotFoundException(id)
        );

    }

    @PostMapping("/new")
    public String addAccommodation(@RequestBody Accommodation newAccommodation){
        repo.save(newAccommodation);
        return "A new accommodation is created.";
    }

    @PutMapping("/{id}")
    public Accommodation updateAccommodation(@PathVariable Long id, @RequestBody Accommodation newAccommodation){
        return repo.findById(id)
        .map(accommodation -> {
            accommodation.setName(newAccommodation.getName());
            accommodation.setType(newAccommodation.getType());
            accommodation.setPax(newAccommodation.getPax());
            accommodation.setPrice(newAccommodation.getPrice());
            accommodation.setStatus(newAccommodation.getStatus());
            accommodation.setUrl(newAccommodation.getUrl());
            return repo.save(accommodation);
        }).orElseGet(() -> {
            return repo.save(newAccommodation);
        });

    }

    @DeleteMapping("/delete/{id}")
    public String deleteAccommodation (@PathVariable Long id){
        repo.deleteById(id);
        return "The accommodation is deleted.";
    }
    
}