package com.kandaharcottages.kctech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.UserDetails;

public interface UserDetailsRepository extends JpaRepository <UserDetails, Long>{

}