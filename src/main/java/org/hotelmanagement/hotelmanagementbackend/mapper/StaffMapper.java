package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.entity.StaffEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.StaffDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

//    @Mapping()
    StaffEntity toEntity(StaffDto staffDto);

    StaffDto toDto(StaffEntity staffEntity);
}
