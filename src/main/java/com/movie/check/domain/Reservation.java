package com.movie.check.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @Generated
    private Long reservationId;

    private Long adultCount;
    private Long childCount;
    private Long totalFee;

    @OneToOne
    private Screening screening;

    private LocalDateTime reservationDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
