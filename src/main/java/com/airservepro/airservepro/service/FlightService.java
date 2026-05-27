package com.airservepro.airservepro.service;

import com.airservepro.airservepro.dto.FlightRegisterDTO;
import com.airservepro.airservepro.dto.FlightResponseDTO;
import com.airservepro.airservepro.model.Flights;
import com.airservepro.airservepro.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    // POST /api/flights

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    //POST /api/flights
    public String registerFlight(FlightRegisterDTO flightDTO)
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
        flights.setSeatsAvailable(flightDTO.totalSeats());
        flights.setPrice(flightDTO.price());
        flights.setStatus(flightDTO.status());

        flightRepository.save(flights);

        return "Flight registered successfully!";
    }

    //GET /api/flights

    public List<FlightResponseDTO> displayFlights()
    {
        List<Flights> flights = flightRepository.findAll();
        List<FlightResponseDTO> flightResponseDTOS = new ArrayList<>();

        for(Flights flight : flights)
        {
            FlightResponseDTO converted=convertToFlightResponseDTO(flight);
            flightResponseDTOS.add(converted);
        }

        return flightResponseDTOS;

    }

    public FlightResponseDTO convertToFlightResponseDTO(Flights flight)
    {
        return new FlightResponseDTO(flight.getAirlineName(),flight.getFlightNo(),flight.getDeparture(),flight.getDestination(),flight.getArrivalTime(),flight.getDepartureTime(),flight.getDepartureDate(),flight.getArrivalDate(),flight.getPrice(),flight.getStatus());
    }


}

/*

GET /api/flights/{id}
PUT /api/flights/{id}
DELETE /api/flights/{id}
 */