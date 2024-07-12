package com.kandaharcottages.kctech.NotFoundException;

public class UserDetailsNotFoundException extends RuntimeException {
    public UserDetailsNotFoundException(Long id){
        super("Could not find user with "  + id);

}

}

