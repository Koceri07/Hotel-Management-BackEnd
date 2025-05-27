package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.MarketItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketItemRepository extends CrudRepository<MarketItemEntity, Long> {
    List<MarketItemEntity> findAll();
}
