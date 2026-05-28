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
    public FlightResponseDTO registerFlight(FlightRegisterDTO flightDTO)
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

        return convertToFlightResponseDTO(flights);
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

    public FlightResponseDTO displayFlightsById(Long id)
    {
        Flights flight = flightRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Flight with id %d not found", id)));

        return convertToFlightResponseDTO(flight);
    }

    //PUT /api/flights/{id}]

    public FlightResponseDTO updateFlightsById(Long id,FlightRegisterDTO flightDTO)
    {
        Flights flight=flightRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Flight with id %d not found", id)));

        flight.setAirlineName(flightDTO.airlineName());

        // TS=180
        // AS=50
        // BS=130
        if(flightDTO.totalSeats() !=0)
        {
            int bookedSeats=flight.getTotalSeats()-flight.getSeatsAvailable(); // 130

            flight.setTotalSeats(flightDTO.totalSeats()); // Incoming DTO -> Larger Plane

            flight.setSeatsAvailable(flight.getTotalSeats()-bookedSeats);
        }

        flight.setFlightNo(flightDTO.flightNo());
        flight.setDeparture(flightDTO.departFrom());
        flight.setDestination(flightDTO.destinationTo());
        flight.setArrivalDate(flightDTO.arrivalDate());
        flight.setArrivalTime(flightDTO.arrivalTime());
        flight.setDepartureTime(flightDTO.departureTime());
        flight.setDepartureDate(flightDTO.departureDate());
        flight.setSeatsAvailable(flightDTO.totalSeats());
        flight.setPrice(flightDTO.price());
        flight.setStatus(flightDTO.status());

        flightRepository.save(flight);

        return convertToFlightResponseDTO(flight);
    }

    public FlightResponseDTO convertToFlightResponseDTO(Flights flight)
    {
        return new FlightResponseDTO(flight.getAirlineName(),flight.getFlightNo(),flight.getDeparture(),flight.getDestination(),flight.getArrivalTime(),flight.getDepartureTime(),flight.getDepartureDate(),flight.getArrivalDate(),flight.getPrice(),flight.getStatus());
    }

}

/*


DELETE /api/flights/{id}
 */