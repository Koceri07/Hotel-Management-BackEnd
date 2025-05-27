package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.entity.MarketSaleEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MarketSaleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MarketSaleMapper {
    MarketSaleMapper INSTANCE = Mappers.getMapper(MarketSaleMapper.class);

    MarketSaleEntity toEntity(MarketSaleDto marketSaleDto);

    MarketSaleDto toDto(MarketSaleEntity marketSaleEntity);
}
