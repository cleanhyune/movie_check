package com.movie.check.service;

import com.movie.check.configuration.customError.MovieNotFoundException;
import com.movie.check.domain.Movie;
import com.movie.check.dto.MovieDto;
import com.movie.check.repository.movie.MovieRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public void save(Movie movie) {
        this.movieRepository.save(movie);
    }

    public List<MovieDto> findMovies() {
        return movieRepository.findMovies();
    }

    public Movie getMovieById(Long id) throws NotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public MovieDto findMovieById(Long movieId) throws MovieNotFoundException {
        return movieRepository.findMovieById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(""));
    }

}
