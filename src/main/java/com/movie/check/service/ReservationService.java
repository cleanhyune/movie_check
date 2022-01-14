package com.movie.check.service;

import com.movie.check.domain.Member;
import com.movie.check.domain.Reservation;
import com.movie.check.domain.Screening;
import com.movie.check.repository.reservation.ReservationDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationDao reservationDao;

    @Transactional
    public void reserve(Screening screening, Member member) {
        Reservation reserve = screening.reserve(member);
        this.save(reserve);
    }


    public void save(Reservation reservation) {
       reservationDao.save(reservation);
    }

    public void reserve(Screening screening, Member member, Long adultCount, Long childCount) {

    }
}
