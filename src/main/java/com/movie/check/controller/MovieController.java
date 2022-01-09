package com.movie.check.controller;

import com.movie.check.configuration.customError.MovieNotFoundException;
import com.movie.check.dto.ApiResponse;
import com.movie.check.dto.MovieDto;
import com.movie.check.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.movie.check.dto.ApiResponse.apiResponse;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ApiResponse<List<MovieDto>> findMovies() {
        List<MovieDto> movies = movieService.findMovies();
        return apiResponse(movies);
    }

    @GetMapping("/{movieId}")
    public ApiResponse<MovieDto> findMovieById(@PathVariable(name = "movieId") Long movieId) throws MovieNotFoundException {
        MovieDto movieById = movieService.findMovieById(movieId);
        return apiResponse(movieById);
    }
}
