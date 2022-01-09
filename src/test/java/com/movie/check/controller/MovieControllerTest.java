package com.movie.check.controller;

import com.movie.check.domain.Movie;
import com.movie.check.dto.MovieDto;
import com.movie.check.service.MovieService;
import com.movie.check.types.Jenre;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieControllerTest {

    @Autowired
    MovieService movieService;

    @BeforeEach
    void initializeMovies() {
        Movie movie = Movie.builder()
                .title("아바타")
                .director("크리스토퍼 놀란")
                .jenre(Jenre.ACTION)
                .openingDate(LocalDateTime.now())
                .synopsis("판타지 영화입니다.")
                .build();
        movieService.save(movie);
    }

    @Test
    void findMovies() {
        List<MovieDto> movies = movieService.findMovies();
        assertNotNull(movies);
    }

    @Test
    void findMovieById() {

    }
}