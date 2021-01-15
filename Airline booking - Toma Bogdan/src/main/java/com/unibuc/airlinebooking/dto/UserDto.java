package com.unibuc.airlinebooking.dto;

import com.unibuc.airlinebooking.domain.UserType;
import com.unibuc.airlinebooking.validators.OnlyLetters;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull(message = "This field is required.")
    @OnlyLetters
    private String username;
    private String password;
    private String name;
    private String email;
    private UserType codCategory;
    private LocalDateTime accountCreated;
    private int age;
    private String gender;
    // Phone number must be unique
    @Column(unique = true)
    private String phone;

}

