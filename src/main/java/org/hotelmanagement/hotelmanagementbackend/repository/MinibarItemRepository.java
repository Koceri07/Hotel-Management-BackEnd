package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.MinibarItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinibarItemRepository extends CrudRepository<MinibarItemEntity, Long> {
    List<MinibarItemEntity> findAll();

}
