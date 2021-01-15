package com.unibuc.airlinebooking.controller;

import com.unibuc.airlinebooking.dto.UserDto;
import com.unibuc.airlinebooking.domain.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unibuc.airlinebooking.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/bronze")
    public ResponseEntity<UserDto> createStudent(@RequestBody @Valid UserDto userDto) {
        UserDto savedUser = userService.create(userDto, UserType.BRONZE);

        return ResponseEntity
                .ok()
                .body(savedUser);
    }

    @PostMapping("/platinum")
    public ResponseEntity<UserDto> createProfessor(@RequestBody @Valid UserDto userDto) {
        UserDto savedUser = userService.create(userDto, UserType.PLATINUM);

        return ResponseEntity
                .ok()
                .body(savedUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> get(@PathVariable("username") String username) {
        UserDto userDto = userService.getOne(username);

        return ResponseEntity
                .ok()
                .body(userDto);
    }
/*
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.save(userDto);
        return new ResponseEntity<>(savedUserDto, null == savedUserDto ? HttpStatus.EXPECTATION_FAILED : HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> get(@PathVariable("id") Long id) {
        UserDto userDto = userService.get(id);
        return new ResponseEntity<>(userDto, null == userDto ? HttpStatus.NOT_FOUND: HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @DeleteMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String remove(@PathVariable("username") String username) {
        boolean result = userService.delete(username);
        return result ? String.format("User %s was removed", username)
                : String.format("User %s was not removed", username);
    }*/
}
