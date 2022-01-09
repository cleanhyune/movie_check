package com.movie.check.repository.movie;

import com.movie.check.domain.Movie;
import com.movie.check.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface CustomMovieRepository {

    List<MovieDto> findMovies();

    Optional<MovieDto> findMovieById(Long movieId);

}
