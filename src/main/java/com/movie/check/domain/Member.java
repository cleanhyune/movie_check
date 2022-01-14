package com.movie.check.domain;

import javax.jdo.annotations.Join;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long memberId;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservationMovies = new ArrayList<>();
}
