package com.movie.check.domain;

import com.movie.check.types.Jenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="movie_seq_gen")
    @SequenceGenerator(name="movie_seq_gen", sequenceName="MOVIE_SEQ")
    private Long movieId;

    private String title;
    private LocalDateTime runningTime;
    private String synopsis;

    @Enumerated(EnumType.STRING)
    private Jenre jenre;

    private LocalDateTime openingDate;
    private String director;



}
