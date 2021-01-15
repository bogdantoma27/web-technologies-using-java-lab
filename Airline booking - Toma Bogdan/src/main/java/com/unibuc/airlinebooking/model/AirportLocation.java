package com.unibuc.airlinebooking.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportLocation {

    private Long idLocation;
    private String city;
    private String Street;
    private int number;
    private int postalCode;
}
