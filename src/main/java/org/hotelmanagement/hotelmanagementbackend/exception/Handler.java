package org.hotelmanagement.hotelmanagementbackend.exception;

import org.hotelmanagement.hotelmanagementbackend.entity.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler
    public ResponseEntity<Error> NotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(e.getMessage(), "Not Found"));
    }
}
