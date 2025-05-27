package org.hotelmanagement.hotelmanagementbackend.exception;

public class StockEmptyException extends RuntimeException {
    public StockEmptyException(String message) {
        super(message);
    }
}
