package com.kandaharcottages.kctech.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.UserDetails;

public interface UserDetailsRepository extends JpaRepository <UserDetails, Long>{

    Optional<UserDetails> findByContact(String contact);
    UserDetails  findByUserAuthId(Long userAuthId);
}