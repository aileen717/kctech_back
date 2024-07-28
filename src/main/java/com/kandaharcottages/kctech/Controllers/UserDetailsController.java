package com.kandaharcottages.kctech.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kandaharcottages.kctech.Model.UserAuth;
import com.kandaharcottages.kctech.Model.UserDetails;
import com.kandaharcottages.kctech.NotFoundException.UserDetailsNotFoundException;
import com.kandaharcottages.kctech.Repository.UserAuthRepository;
import com.kandaharcottages.kctech.Repository.UserDetailsRepository;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/profile")
public class UserDetailsController {

    private final UserDetailsRepository repo;
    private final UserAuthRepository userAuthRepository;

    public UserDetailsController(UserDetailsRepository repo, UserAuthRepository userAuthRepository) {
        this.repo = repo;
        this.userAuthRepository = userAuthRepository;
        }

    // @GetMapping("/{id}")
    // public Long getUserProfile(@PathVariable String email){
    //     UserAuth userAuth = userAuthRepository.findByEmail(email);
    //     return userAuth.getId();
    // }

    

    @GetMapping("account/{email}")
    public HashMap<String, String>getMail(@PathVariable String email) {
        UserAuth userAuth = userAuthRepository.findByEmail(email);
        UserDetails userDetails = repo.findByUserAuthId(userAuth.getId());

        HashMap<String, String> profile = new HashMap<String, String>();

        profile.put("name", userDetails.getName());
        profile.put("contact", userDetails.getContact());
        profile.put("address", userDetails.getAddress());

        return profile;
    }

    @GetMapping("/{email}")
    public Long getUserAccount(@PathVariable String email) {
        UserAuth user = userAuthRepository.findByEmail(email);
        return user.getId();
    }
    

    @PostMapping("/addinfo")
    public UserDetails createProfile(@RequestBody UserDetails newProfile) {
        return repo.save(newProfile);
    }

    @PutMapping("/edit/{id}")
    public UserDetails updateProfile(@PathVariable Long id, @RequestBody UserDetails updatedProfile) {
        return repo.findById(id)
                .map(profile -> {
                    profile.setContact(updatedProfile.getContact());
                    profile.setAddress(updatedProfile.getAddress());
                    return repo.save(profile);
                })
                .orElseThrow(() -> new UserDetailsNotFoundException(id));
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProfile(@PathVariable Long id) {
        repo.deleteById(id);
        return "Profile with ID " + id + " has been deleted";
    }
    
}
