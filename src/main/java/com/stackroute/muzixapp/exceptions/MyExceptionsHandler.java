package com.stackroute.muzixapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionsHandler {
    @ExceptionHandler(TrackNotFound.class)
    public ResponseEntity<Object> myMessage(TrackNotFound tr){
        return new ResponseEntity<>(tr.getMessage(), HttpStatus.NO_CONTENT);
    }
}
