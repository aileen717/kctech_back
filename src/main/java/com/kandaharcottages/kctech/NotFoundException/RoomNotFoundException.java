package com.kandaharcottages.kctech.NotFoundException;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id){
        super("Could not find room with "  + id);

}

}
