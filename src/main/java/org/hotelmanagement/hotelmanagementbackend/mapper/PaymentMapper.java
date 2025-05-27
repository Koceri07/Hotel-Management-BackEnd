package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.entity.PaymentEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentEntity toEntity(PaymentDto paymentDto);

    PaymentDto toDto(PaymentEntity paymentEntity);
}
