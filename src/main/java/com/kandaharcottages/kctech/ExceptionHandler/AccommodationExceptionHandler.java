package com.kandaharcottages.kctech.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kandaharcottages.kctech.NotFoundException.AccommodationNotFoundException;

@RestControllerAdvice
public class AccommodationExceptionHandler {
    @ExceptionHandler(AccommodationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(AccommodationNotFoundException e){
        return e.getMessage();
    }

}

