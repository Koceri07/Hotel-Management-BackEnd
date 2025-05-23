package org.hotelmanagement.hotelmanagementbackend.repository;

import org.hotelmanagement.hotelmanagementbackend.entity.MailEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MailDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends CrudRepository<MailEntity, Long> {
    List<MailEntity> findAll();
//    MailEntity findById(Long id);
}
