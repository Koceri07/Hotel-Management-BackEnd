package org.hotelmanagement.hotelmanagementbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.entity.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class Handler {

    @ExceptionHandler
    public ResponseEntity<Error> StockEmptyException(StockEmptyException e){
        log.error("Stock Is Empty");
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(new Error(e.getMessage(), "Stock Is Empty"));
    }

    @ExceptionHandler
    public ResponseEntity<Error> NotFoundException(NotFoundException e){
        log.error("Error for Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(e.getMessage(), "Not Found"));
    }

    @ExceptionHandler
    public ResponseEntity<Error> ReservationAlreadyExists(ReservationAlreadyExists e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(e.getMessage(), "Reservation Already Exists"));
    }


    @ExceptionHandler
    public ResponseEntity<Error> UnAuthorized(UnAuthorizedException e){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new Error(e.getMessage(), "UnAuthorized"));
    }
}
