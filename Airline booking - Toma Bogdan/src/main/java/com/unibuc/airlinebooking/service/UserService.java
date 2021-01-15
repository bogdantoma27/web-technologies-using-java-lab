package com.unibuc.airlinebooking.service;


import com.unibuc.airlinebooking.model.User;
import com.unibuc.airlinebooking.dto.UserDto;
import com.unibuc.airlinebooking.mapper.UserMapper;
import com.unibuc.airlinebooking.domain.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unibuc.airlinebooking.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public UserDto create(UserDto userDto, UserType userType) {
        User user = userMapper.mapToEntity(userDto);
        user.setUserType(userType);

        User savedUser = userRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }

    public UserDto getOne(String username) {
        User user = userRepository.get(username);

        return userMapper.mapToDto(user);
    }
/*
    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto save(UserDto userDto) {
        // map dto to entity
        User user = this.userMapper.mapToEntity(userDto);
        // saved entity in database
        User savedUser = userRepository.save(user);
        // mapped entity back to dto
        UserDto saveUserDto = this.userMapper.mapToDto(savedUser);
        // return saved dto
        return saveUserDto;
    }

    public UserDto get(Long id) {
        User user = userRepository.getOne(id);
        return this.userMapper.mapToDto(user);
    }

    public List<UserDto> getAll() {
        return userRepository.getAll()
                .stream()
                .map(user -> userMapper.mapToDto(user))
                .collect(Collectors.toList());
    }

    public boolean delete(String username) {
        Optional<User> optionalUser = userRepository.getAll()
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny();
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return true;
        }
        return false;
    }
    */

}
