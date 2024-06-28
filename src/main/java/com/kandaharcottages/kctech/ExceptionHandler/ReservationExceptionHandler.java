package com.kandaharcottages.kctech.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kandaharcottages.kctech.NotFoundException.ReservationNotFoundException;

@RestControllerAdvice
public class ReservationExceptionHandler {
    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(ReservationNotFoundException e){
        return e.getMessage();
    }

}

