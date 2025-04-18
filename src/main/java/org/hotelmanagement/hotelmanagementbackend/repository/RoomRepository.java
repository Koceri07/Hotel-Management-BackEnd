package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.RoomEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

    List<RoomEntity> findAll();

    @Query(value = "SELECT room_number FROM rooms WHERE is_available  = true ORDER BY id LIMIT 1;", nativeQuery = true)
    int findFirstEmptyRoom();

    @Modifying
    @Query(value = "UPDATE rooms SET is_available = false WHERE is_available = true ORDER BY id LIMIT 1;", nativeQuery = true)
    void changeIsAvailableFalse();

//    @Query(value = "SELECT id FROM rooms WHERE is_available  = true ORDER BY id LIMIT 1;", nativeQuery = true)
//    Long findFirstEmptyRoomId();

}

