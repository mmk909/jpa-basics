package com.example.crud.entity;

import com.example.crud.dto.UserRequest;
import com.example.crud.dto.UserResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
//    User toEntity(UserDto userDto);
//
//    UserDto toDto(User user);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    User partialUpdate(UserDto userDto, @MappingTarget User user);

    UserResponse toResponse(User entity);

    User toEntity(UserRequest request);

    void updateEntityFromRequest(UserRequest request, @MappingTarget User entity);
}