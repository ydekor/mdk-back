package com.ydekor.mdk.mapper;

import com.ydekor.mdk.dto.UserDTO;
import com.ydekor.mdk.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {
    @Override
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "departmentId", source = "department.id")
    UserDTO sourceToDto(User userDTO);
    @Override
    @Mapping(target = "department.id", source = "departmentId")
    User dtoToSource(UserDTO userDTO);
}
