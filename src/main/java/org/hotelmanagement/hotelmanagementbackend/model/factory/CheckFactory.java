package org.hotelmanagement.hotelmanagementbackend.model.factory;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface CheckFactory {

    boolean isHaveReservedRoomFactory(int roomNumber);
    boolean isHaveReservationDateFactory(LocalDateTime localDateTime);
}
