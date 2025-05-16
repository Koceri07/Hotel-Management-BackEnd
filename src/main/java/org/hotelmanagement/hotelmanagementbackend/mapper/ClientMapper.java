package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.model.dto.ClientDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

//    @Mapping(target = "id", ignore = true)
    ClientEntity toEntity(ClientDto clientDto);

//    @Mapping(target = "id", ignore = true)
    ClientDto toDto(ClientEntity clientEntity);
}
