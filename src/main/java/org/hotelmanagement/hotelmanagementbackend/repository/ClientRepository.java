package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    List<ClientEntity> findAll();

//    @Modifying
    @Modifying
    @Query("UPDATE ClientEntity c SET c.isActive = false WHERE c.id = :id")
    void deactivateClient(@Param("id") Long id);

//    void chechOut(@Param("id") Long id);
}
