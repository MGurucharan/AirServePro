package com.airservepro.airservepro.model;

import com.airservepro.airservepro.enums.FlightStatus;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String airlineName;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(unique = true, nullable = false)
    private String flightNo;

    @Column( nullable = false)
    private String departure;

    @Column( nullable = false)
    private String destination;

    @Column( nullable = false)
    private LocalTime arrivalTime;

    @Column(nullable = false)
    private LocalTime departureTime;

    @Column( nullable = false)
    private LocalDate arrivalDate;

    @Column( nullable = false)
    private LocalDate departureDate;

    @Column(nullable = false)
    private Integer seatsAvailable;

    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings;


    private Double price;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
