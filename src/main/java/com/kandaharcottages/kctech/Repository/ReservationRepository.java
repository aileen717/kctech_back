package com.kandaharcottages.kctech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kandaharcottages.kctech.Model.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Long>{

}
