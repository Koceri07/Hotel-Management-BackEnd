package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.entity.MailEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailMapper {

    MailMapper INSTANCE = Mappers.getMapper(MailMapper.class);

//    @Mapping(target = "id",ignore = true)
    MailDto toDto(MailEntity mailEntity);

//    @Mapping(target = "id",ignore = true)
    MailEntity toEntity(MailDto mailDto);
}
