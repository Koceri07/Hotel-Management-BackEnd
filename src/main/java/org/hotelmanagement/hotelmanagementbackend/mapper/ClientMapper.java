package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.dto.ClientDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientEntity toEntity(ClientDto clientDto);

    ClientDto toDto(ClientEntity clientEntity);
}
