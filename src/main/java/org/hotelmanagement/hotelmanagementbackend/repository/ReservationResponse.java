package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationResponse extends CrudRepository<ReservationEntity,Long> {
    List<ReservationEntity> findAll();
//
//    @Query(value = "SELECT reservation_date FROM reservations;", nativeQuery = true)
//    List<LocalDateTime> findAllReservationDate();

    @Query("SELECT r.reservationDate FROM ReservationEntity r")
    List<LocalDateTime> findAllReservationDate();


    @Query(value = "SELECT r.room_number FROM reservations r;" , nativeQuery = true)
    List<Integer> findAllReservedRooms();
}
