package com.movie.check.repository.reservation;

import com.movie.check.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long> {

}
