package com.airservepro.airservepro.service;

import com.airservepro.airservepro.dto.FlightDTO;
import com.airservepro.airservepro.model.Flights;
import com.airservepro.airservepro.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    // POST /api/flights

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public String registerFlight(FlightDTO flightDTO)
    {
        Flights flights = new Flights();

        flights.setAirlineName(flightDTO.airlineName());
        flights.setTotalSeats(flightDTO.totalSeats());
        flights.setFlightNo(flightDTO.flightNo());
        flights.setDeparture(flightDTO.departFrom());
        flights.setDestination(flightDTO.destinationTo());
        flights.setArrivalDate(flightDTO.arrivalDate());
        flights.setArrivalTime(flightDTO.arrivalTime());
        flights.setDepartureTime(flightDTO.departureTime());
        flights.setDepartureDate(flightDTO.departureDate());
        flights.setSeatsAvailable(flightDTO.availableSeats());
        flights.setPrice(flightDTO.price());
        flights.setStatus(flightDTO.status());

        flightRepository.save(flights);

        return "Flight registered successfully!";
    }

}

/*
POST /api/flights
GET /api/flights
GET /api/flights/{id}
PUT /api/flights/{id}
DELETE /api/flights/{id}
 */