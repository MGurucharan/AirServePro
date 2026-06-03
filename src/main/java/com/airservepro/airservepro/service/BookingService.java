package com.airservepro.airservepro.service;

import com.airservepro.airservepro.dto.BookingRequestDTO;
import com.airservepro.airservepro.enums.BookingStatus;
import com.airservepro.airservepro.model.Booking;
import com.airservepro.airservepro.model.Flights;
import com.airservepro.airservepro.model.Users;
import com.airservepro.airservepro.repository.BookingRepository;
import com.airservepro.airservepro.repository.FlightRepository;
import com.airservepro.airservepro.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository=userRepository;
        this.flightRepository=flightRepository;
    }

    @Transactional
    public String createBooking(BookingRequestDTO bookingRequestDTO) {
        // Find User

        System.out.println("User ID = " + bookingRequestDTO.userId());
        System.out.println("Flight ID = " + bookingRequestDTO.flightId());

        Users user=userRepository.findById(bookingRequestDTO.userId()).orElseThrow(()->new RuntimeException("User not found"));

        // Find Flight also

        Flights flight=flightRepository.findById(bookingRequestDTO.flightId()).orElseThrow(()->new RuntimeException("Flight not found"));

        Integer seatsAvailable=flight.getSeatsAvailable();

        Integer seatsBooked= bookingRequestDTO.seatsBooked();

        if((seatsAvailable-seatsBooked)<0)
        {
            throw new RuntimeException("Seats not available");
        }

        flight.setSeatsAvailable(flight.getSeatsAvailable()-seatsBooked);
        flightRepository.save(flight);

        Booking booking=new Booking();

        booking.setUser(user);
        booking.setFlight(flight);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setBookingDate(LocalDate.now());
        booking.setSeatsBooked(seatsBooked);

        booking=bookingRepository.save(booking);


        String pnr="ASP2026"+String.format("%06d",booking.getId());

        booking.setPnr(pnr);
        bookingRepository.save(booking);

        return "Booking created successfully. PNR: " + pnr;

    }

}
