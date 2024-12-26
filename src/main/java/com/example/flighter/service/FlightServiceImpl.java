package com.example.flighter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flighter.entity.Flight;
import com.example.flighter.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public boolean deleteFlightById(Integer id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Flight updateFlight(Integer id, Flight updatedFlight) {
        Optional<Flight> existingFlight = flightRepository.findById(id);
        if (existingFlight.isPresent()) {
            Flight flight = existingFlight.get();
            flight.setFlightNumber(updatedFlight.getFlightNumber());
            flight.setAirline(updatedFlight.getAirline());
            flight.setOrigin(updatedFlight.getOrigin());
            flight.setDestination(updatedFlight.getDestination());
            flight.setArrivalTime(updatedFlight.getArrivalTime());
            flight.setStatus(updatedFlight.getStatus());
            flight.setPrice(updatedFlight.getPrice());
            return flightRepository.save(flight);
        }
        return null;
    }

    @Override
    public Flight addFlight(Flight newFlight) {
        return flightRepository.save(newFlight);
    }

    @Override
    public Flight getFlightByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }
}
