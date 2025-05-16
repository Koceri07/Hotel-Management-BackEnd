package org.hotelmanagement.hotelmanagementbackend.mapper;

import org.hotelmanagement.hotelmanagementbackend.model.dto.CommentDto;
import org.hotelmanagement.hotelmanagementbackend.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

//    @Mapping(target = "id",ignore = true)
    CommentEntity toEntity(CommentDto commentDto);

//    @Mapping(target = "id",ignore = true)
    CommentDto toDto(CommentEntity commentEntity);
}
