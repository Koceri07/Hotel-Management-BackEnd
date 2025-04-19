package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationResponse extends CrudRepository<ReservationEntity,Long> {
    List<ReservationEntity> findAll();
}
