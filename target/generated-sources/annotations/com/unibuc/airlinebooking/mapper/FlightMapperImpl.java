package com.unibuc.airlinebooking.mapper;

import com.unibuc.airlinebooking.dto.FlightDto;
import com.unibuc.airlinebooking.model.FlightInformation;
import com.unibuc.airlinebooking.model.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-15T17:41:31+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (AdoptOpenJDK)"
)
@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightInformation mapToEntity(FlightDto flightDto) {
        if ( flightDto == null ) {
            return null;
        }

        FlightInformation flightInformation = new FlightInformation();

        flightInformation.setFlightNumber( flightDto.getFlightNumber() );
        flightInformation.setPrice( flightDto.getPrice() );
        flightInformation.setFrom( flightDto.getFrom() );
        flightInformation.setTo( flightDto.getTo() );
        flightInformation.setDepartureTime( flightDto.getDepartureTime() );
        flightInformation.setArrivalTime( flightDto.getArrivalTime() );
        flightInformation.setDescription( flightDto.getDescription() );
        flightInformation.setPlane( flightDto.getPlane() );
        List<Reservation> list = flightDto.getReservations();
        if ( list != null ) {
            flightInformation.setReservations( new ArrayList<Reservation>( list ) );
        }
        flightInformation.setSeatsLeft( flightDto.getSeatsLeft() );

        return flightInformation;
    }

    @Override
    public FlightDto mapToDto(FlightInformation flightInformation) {
        if ( flightInformation == null ) {
            return null;
        }

        FlightDto flightDto = new FlightDto();

        flightDto.setPrice( flightInformation.getPrice() );
        flightDto.setFlightNumber( flightInformation.getFlightNumber() );
        flightDto.setFrom( flightInformation.getFrom() );
        flightDto.setTo( flightInformation.getTo() );
        flightDto.setDepartureTime( flightInformation.getDepartureTime() );
        flightDto.setArrivalTime( flightInformation.getArrivalTime() );
        flightDto.setDescription( flightInformation.getDescription() );
        flightDto.setPlane( flightInformation.getPlane() );
        List<Reservation> list = flightInformation.getReservations();
        if ( list != null ) {
            flightDto.setReservations( new ArrayList<Reservation>( list ) );
        }
        flightDto.setSeatsLeft( flightInformation.getSeatsLeft() );

        return flightDto;
    }
}
