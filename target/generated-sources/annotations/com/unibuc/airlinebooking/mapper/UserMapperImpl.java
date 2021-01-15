package com.unibuc.airlinebooking.mapper;

import com.unibuc.airlinebooking.dto.UserDto;
import com.unibuc.airlinebooking.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-15T17:41:31+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (AdoptOpenJDK)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setName( userDto.getName() );
        user.setEmail( userDto.getEmail() );
        user.setAccountCreated( userDto.getAccountCreated() );
        user.setAge( userDto.getAge() );
        user.setGender( userDto.getGender() );
        user.setPhone( userDto.getPhone() );

        return user;
    }

    @Override
    public UserDto mapToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUsername( user.getUsername() );
        userDto.setPassword( user.getPassword() );
        userDto.setName( user.getName() );
        userDto.setEmail( user.getEmail() );
        userDto.setAccountCreated( user.getAccountCreated() );
        userDto.setAge( user.getAge() );
        userDto.setGender( user.getGender() );
        userDto.setPhone( user.getPhone() );

        return userDto;
    }
}
