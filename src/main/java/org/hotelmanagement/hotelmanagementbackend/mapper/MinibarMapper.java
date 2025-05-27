package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.entity.MinibarItemEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MinibarItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MinibarMapper {
    MinibarMapper INSTANCE = Mappers.getMapper(MinibarMapper.class);

    MinibarItemEntity toEntity(MinibarItemDto minibarItemDto);

    MinibarItemDto toDto(MinibarItemEntity minibarItemEntity);
}
