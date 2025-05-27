package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.StaffEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffRepository extends CrudRepository<StaffEntity, Long> {
    List<StaffEntity> findAll();
}
