package com.stackroute.muzixapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionsHandler {
    @ExceptionHandler(TrackNotFound.class)
    public ResponseEntity<Object> myMessage(TrackNotFound tr){
        return new ResponseEntity<>(tr.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(TrackAlreadyExists.class)
    public ResponseEntity<Object> message(TrackAlreadyExists tr){
        return new ResponseEntity<>(tr.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> myMessage(Exception e)
    {
        return new ResponseEntity<>("Internal Server Error", HttpStatus.CONFLICT);
    }

}
