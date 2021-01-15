package com.unibuc.airlinebooking.service;

import com.unibuc.airlinebooking.dto.FlightDto;
import com.unibuc.airlinebooking.mapper.FlightMapper;
import com.unibuc.airlinebooking.model.FlightInformation;
import com.unibuc.airlinebooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    private FlightMapper flightMapper;

    public FlightService(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    public FlightDto save(FlightDto flightDto) {
        // map dto to entity
        FlightInformation flight = this.flightMapper.mapToEntity(flightDto);
        // saved entity in database
        FlightInformation savedFlight = flightRepository.save(flight);
        // mapped entity back to dto
        FlightDto saveFlightDto = this.flightMapper.mapToDto(savedFlight);
        // return saved dto
        return saveFlightDto;
    }

    public FlightDto get(Long id) {
        FlightInformation flight = flightRepository.getOne(id);
        return this.flightMapper.mapToDto(flight);
    }

    public List<FlightDto> getAll() {
        return flightRepository.getAll()
                .stream()
                .map(flight -> flightMapper.mapToDto(flight))
                .collect(Collectors.toList());
    }

    public boolean delete(String flightnumber) {
        Optional<FlightInformation> optionalFlight = flightRepository.getAll()
                .stream()
                .filter(user -> user.getFlightNumber().equals(flightnumber))
                .findAny();
        if (optionalFlight.isPresent()) {
            flightRepository.delete(optionalFlight.get());
            return true;
        }
        return false;
    }




}
