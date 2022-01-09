package com.movie.check.dto;

import com.movie.check.types.Jenre;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieDto {

    private Long movieId;
    private String title;
    private String synopsis;
    private Jenre jenre;
    private String director;
    private LocalDateTime openingDate;
    private LocalDateTime runningTime;

}
