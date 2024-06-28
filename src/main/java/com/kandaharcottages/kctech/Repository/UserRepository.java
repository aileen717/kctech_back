package com.kandaharcottages.kctech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.User;

public interface UserRepository extends JpaRepository <User, Long>{

}

