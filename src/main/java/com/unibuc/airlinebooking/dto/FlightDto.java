package com.unibuc.airlinebooking.dto;

import com.unibuc.airlinebooking.model.Plane;
import com.unibuc.airlinebooking.model.Reservation;
import lombok.*;

import java.util.List;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

    //private int name;
    //private List<FlightType> flighttype;
    //private int flightduration;
    //private int minimumAge;
    //private Boolean firstclassseat;

    private int price;
    private String flightNumber;
    private String from;
    private String to;
    private String departureTime;
    private String arrivalTime;
    private String description;
    private Plane plane;
    private List<Reservation> reservations;
    private int seatsLeft;
}
