package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {
    List<PaymentEntity> findAll();
}
