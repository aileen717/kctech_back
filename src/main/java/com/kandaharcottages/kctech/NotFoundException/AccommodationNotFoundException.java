package com.kandaharcottages.kctech.NotFoundException;

public class AccommodationNotFoundException extends RuntimeException {
    public AccommodationNotFoundException(Long id){
        super("Could not find accommodation with "  + id);

}

}