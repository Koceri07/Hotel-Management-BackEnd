package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.dto.ClientDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;

import org.hotelmanagement.hotelmanagementbackend.entity.DeletedClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeletedClientMapper {
    DeletedClientMapper INSTANCE = Mappers.getMapper(DeletedClientMapper.class);

    @Mapping(target = "id", ignore = true)
    DeletedClientEntity dtoToDeletedClient(ClientDto clientDto);

//    @Mapping(target = "id", ignore = true)
    DeletedClientEntity entityToDeletedClient(ClientEntity clientEntity);

}
