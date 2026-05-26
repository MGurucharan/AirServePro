package com.airservepro.airservepro.controller;

import com.airservepro.airservepro.dto.FlightDTO;
import com.airservepro.airservepro.service.FlightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/flights"))
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/register")
    public String registerFlight(@RequestBody FlightDTO flightDTO)
    {
        return flightService.registerFlight(flightDTO);
    }

}
