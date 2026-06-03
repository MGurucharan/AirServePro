package com.airservepro.airservepro.repository;

import com.airservepro.airservepro.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
