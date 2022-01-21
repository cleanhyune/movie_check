package com.movie.check.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="screening_seq_gen")
    @SequenceGenerator(name="screening_seq_gen", sequenceName="SCREENING_SEQ")
    private Long screeningId;

    @OneToOne
    private Movie movie;
    private LocalDate runningDay;
    private LocalTime startTime;
    private LocalTime endTime;

    public Reservation reserve(Member member, Long adultCount, Long childCount) {
        return Reservation.builder()
                .adultCount(adultCount)
                .childCount(childCount)
                .totalFee(getTotalFee(adultCount, childCount))
                .screening(this)
                .reservationDate(LocalDateTime.now())
                .member(member)
                .build();
    }

    public Long getTotalFee(Long adultCount, Long childCount) {
        Long fee = movie.getFee();
        return (fee * adultCount) + (long)((fee * 0.9) * childCount) ;
    }

}
