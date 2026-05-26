package com.airservepro.airservepro.repository;

import com.airservepro.airservepro.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights,Long> {
}
