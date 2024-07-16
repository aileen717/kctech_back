package com.kandaharcottages.kctech.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kandaharcottages.kctech.NotFoundException.RoomNotFoundException;

@RestControllerAdvice
public class RoomExceptionHandler {
    @ExceptionHandler(RoomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String roomNotFoundHandler(RoomNotFoundException e){
        return e.getMessage();
    }

}
