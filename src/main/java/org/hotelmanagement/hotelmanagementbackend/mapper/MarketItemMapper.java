package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.entity.MarketItemEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MarketItemMapper {
    MarketItemMapper INSTANCE = Mappers.getMapper(MarketItemMapper.class);

    MarketItemEntity toEntity(MarketItemDto marketItemDto);

    MarketItemDto toDto(MarketItemEntity marketItemEntity);
}
