package com.airservepro.airservepro.dto;

public record BookingRequestDTO
        (
            Long userId,
            Long flightId,
            Integer seatsBooked
        ) {
}
