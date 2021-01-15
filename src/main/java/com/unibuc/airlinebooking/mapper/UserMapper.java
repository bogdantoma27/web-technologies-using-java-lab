package com.unibuc.airlinebooking.mapper;

import com.unibuc.airlinebooking.dto.UserDto;
import com.unibuc.airlinebooking.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User mapToEntity(UserDto userDto);

    UserDto mapToDto(User user);
}
