package com.airservepro.airservepro.dto;

import com.airservepro.airservepro.enums.FlightStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record FlightDTO(
        String airlineName,
        String flightNo,
        Integer totalSeats,
        String departFrom,
        String destinationTo,
        LocalTime arrivalTime,
        LocalTime departureTime,
        LocalDate departureDate,
        LocalDate arrivalDate,
        Double price,
        FlightStatus status,
        Integer availableSeats
) {
}
