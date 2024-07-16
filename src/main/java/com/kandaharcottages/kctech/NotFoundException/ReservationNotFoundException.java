package com.kandaharcottages.kctech.NotFoundException;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long id){
        super("Could not find reservation with "  + id);

}

}
