package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.MarketSaleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketSaleRepository extends CrudRepository<MarketSaleEntity, Long> {
    List<MarketSaleEntity> findAll();
//    Optional<MarketSaleEntity> findById(Long id);
//    Double findPriceByRoomId();
    @Query(value = "SELECT id FROM market_sale WHERE room_number = :room_number LIMIT 1;",nativeQuery = true)
    Long findIdByRoomNumber(@Param("room_number") Integer roomNumber);

    @Query(value = "SELECT room_number FROM market_sale WHERE id = :id LIMIT 1;", nativeQuery = true)
    Integer findRoomNumberById(@Param("id") Long id);
}



/*
SELECT id FROM your_table_name WHERE room_number = '101' LIMIT 1;
 */
