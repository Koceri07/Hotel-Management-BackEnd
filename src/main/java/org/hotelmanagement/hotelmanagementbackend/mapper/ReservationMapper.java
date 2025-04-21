package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.dto.ReservationDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

//    @Mapping(target = "id", ignore = true)
    ReservationEntity toEntity(ReservationDto reservationDto);

    ReservationDto toDto(ReservationEntity reservationEntity);
}
