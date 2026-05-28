package com.airservepro.airservepro.controller;

import com.airservepro.airservepro.dto.FlightRegisterDTO;
import com.airservepro.airservepro.dto.FlightResponseDTO;
import com.airservepro.airservepro.model.Flights;
import com.airservepro.airservepro.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/flights"))
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/register")
    public String registerFlight(@RequestBody FlightRegisterDTO flightDTO)
    {
        return flightService.registerFlight(flightDTO);
    }

    @GetMapping("/display")
    public List<FlightResponseDTO> displayFlights()
    {
        return flightService.displayFlights();
    }

    @GetMapping("/display/{id}")
    public FlightResponseDTO displayFlight(@PathVariable Long id)
    {
        return flightService.displayFlightsById(id);
    }

    @PutMapping("/update/{id}")
    public FlightResponseDTO updateFlight(@PathVariable Long id,@RequestBody FlightRegisterDTO flightDTO)
    {
        return flightService.updateFlightsById(id,flightDTO);
    }

}
