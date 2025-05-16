package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.model.dto.RoomDto;
import org.hotelmanagement.hotelmanagementbackend.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomEntity toEntity(RoomDto roomDto);

    RoomDto toDto(RoomEntity roomEntity);
}
