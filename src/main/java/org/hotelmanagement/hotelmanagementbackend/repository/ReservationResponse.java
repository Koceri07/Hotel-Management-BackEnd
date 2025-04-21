package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationResponse extends CrudRepository<ReservationEntity,Long> {
    List<ReservationEntity> findAll();

    @Query(value = "SELECT c.room_number FROM clients c JOIN rooms r on c.room_number = r.room_number;", nativeQuery = true)
    List<LocalDateTime> findAllReservationDate();

    @Query(value = "SELECT r.room_number FROM reservations r;" , nativeQuery = true)
    List<Integer> findAllReservedRooms();
}
