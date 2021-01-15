package com.unibuc.airlinebooking.model;


import com.unibuc.airlinebooking.domain.UserType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserCategory {

    private UserType codCategory;
    private String reservationTimeLeft;
    private Double discount;

}
