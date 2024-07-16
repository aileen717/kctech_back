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

import com.kandaharcottages.kctech.Model.Room;
import com.kandaharcottages.kctech.NotFoundException.RoomNotFoundException;
import com.kandaharcottages.kctech.Repository.RoomRepository;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    RoomRepository repo;

    public RoomController(RoomRepository repo){
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Room> getRooms(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            () -> new RoomNotFoundException(id)
        );

    }

    @PostMapping("/new")
    public String addRoom(@RequestBody Room newRoom){
        repo.save(newRoom);
        return "A new room is created.";
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room newRoom){
        return repo.findById(id)
        .map(room -> {
            room.setName(newRoom.getName());
            room.setPax(newRoom.getPax());
            room.setPrice(newRoom.getPrice());
            room.setReserved(newRoom.getReserved());
            room.setUrl(newRoom.getUrl());
            return repo.save(room);
        }).orElseGet(() -> {
            return repo.save(newRoom);
        });

    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom (@PathVariable Long id){
        repo.deleteById(id);
        return "The room is deleted.";
    }
    
}
