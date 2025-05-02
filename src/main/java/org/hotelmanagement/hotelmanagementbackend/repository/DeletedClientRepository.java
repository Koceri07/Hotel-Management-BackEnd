package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.DeletedClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeletedClientRepository extends CrudRepository<DeletedClientEntity, Long> {

    List<DeletedClientEntity> findAll();
}
