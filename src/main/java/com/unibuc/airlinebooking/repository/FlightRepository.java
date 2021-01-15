package com.unibuc.airlinebooking.repository;

import com.unibuc.airlinebooking.model.FlightInformation;
import com.unibuc.airlinebooking.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class FlightRepository implements DaoRepository<FlightInformation> {

    private Long id = 0L;
    private final HashMap<Long, FlightInformation> flightInfoList = new HashMap<>();

    @Override
    public FlightInformation save(FlightInformation flightInformation) {
        flightInformation.setFlightcreated(LocalDateTime.now());
        flightInfoList.put(id++, flightInformation);
        return flightInformation;
    }

    @Override
    public boolean delete(FlightInformation object) {
        return false;
    }

    public boolean delete(User object) {
        Optional<Long> flightKey = flightInfoList.keySet()
                .stream()
                .filter(key -> flightInfoList.get(key).equals(object))
                .findAny();
        if (flightKey.isPresent()) {
            flightInfoList.remove(flightKey.get(), object);
            return true;
        }
        return false;
    }

    @Override
    public FlightInformation getOne(Long id) {
        return flightInfoList.get(id);
    }

    @Override
    public List<FlightInformation> getAll() {
        return new ArrayList<>(flightInfoList.values());
    }
}
