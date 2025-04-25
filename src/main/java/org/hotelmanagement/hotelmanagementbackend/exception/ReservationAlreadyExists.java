package org.hotelmanagement.hotelmanagementbackend.exception;

public class ReservationAlreadyExists extends RuntimeException {
  public ReservationAlreadyExists(String message) {
    super(message);
  }
}
