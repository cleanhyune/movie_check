package com.movie.check.domain;

import com.movie.check.types.Jenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
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
    private LocalTime runningTime;
    private String synopsis;

    private Long fee;

    @Enumerated(EnumType.STRING)
    private Jenre jenre;

    private LocalDate openingDate;
    private String director;

}
