package com.example.flighter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.flighter.entity.Flight;
import com.example.flighter.service.FlightService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/flighter/api")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getFlightDetails() {
        List<Flight> flights = flightService.getAllFlights();
        if (flights.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flights);
    }

    @DeleteMapping("/flights/{id}")
    @Transactional
    public ResponseEntity<Void> deleteFlightEntry(@PathVariable("id") Integer id) {
        if (flightService.deleteFlightById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/flights/{id}")
    @Transactional
    public ResponseEntity<Flight> updateFlightEntry(@PathVariable("id") Integer id, @RequestBody Flight updatedFlight) {
        Flight flight = flightService.updateFlight(id, updatedFlight);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/flights")
    public ResponseEntity<Flight> addFlightEntry(@RequestBody Flight newFlight) {
        Flight flight = flightService.addFlight(newFlight);
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/flights/{flight_number}")
    public ResponseEntity<Flight> getFlightEntryByFlightNumber(@PathVariable("flight_number") String flightNumber) {
        Flight flight = flightService.getFlightByFlightNumber(flightNumber);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        }
        return ResponseEntity.notFound().build();
    }
}
