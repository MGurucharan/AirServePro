package com.airservepro.airservepro.controller;


import com.airservepro.airservepro.dto.BookingRequestDTO;
import com.airservepro.airservepro.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public String createBooking(@RequestBody BookingRequestDTO dto)
    {
        return bookingService.createBooking(dto);
    }
}
