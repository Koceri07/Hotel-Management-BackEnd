package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.DeletedClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeletedClientRepository extends CrudRepository<DeletedClientEntity, Long> {

    List<DeletedClientEntity> findAll();
}
