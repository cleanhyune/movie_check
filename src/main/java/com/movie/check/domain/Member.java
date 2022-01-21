package com.movie.check.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long memberId;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservationMovies = new ArrayList<>();

}
