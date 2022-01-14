package com.movie.check.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    @Generated
    private Long screeningId;

    @OneToOne
    private Movie movie;
    private LocalDateTime runningDay;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Reservation reserve(Member member) {
        return new Reservation();
    }

}
