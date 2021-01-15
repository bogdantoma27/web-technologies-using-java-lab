package com.unibuc.airlinebooking.mapper;

import com.unibuc.airlinebooking.dto.FlightDto;
import com.unibuc.airlinebooking.model.FlightInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper {


    FlightInformation mapToEntity(FlightDto flightDto);

    FlightDto mapToDto(FlightInformation flightInformation);
}
