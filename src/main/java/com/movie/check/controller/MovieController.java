package com.movie.check.controller;

import com.movie.check.configuration.customError.MovieNotFoundException;
import com.movie.check.dto.ApiResponse;
import com.movie.check.dto.MovieDto;
import com.movie.check.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value = "영화 리스트 반환", notes = "조건에 맞는 영화리스트를 반환")
    public ResponseEntity<ApiResponse<List<MovieDto>>> findMovies() {
        List<MovieDto> movies = movieService.findMovies();
        return ResponseEntity.ok(apiResponse(movies));
    }

    @GetMapping("/{movieId}")
    @ApiOperation(value = "영화 반환", notes = "조건에 맞는 영화를 반환")
    public ResponseEntity<ApiResponse<MovieDto>> findMovieById(@PathVariable(name = "movieId") Long movieId) throws MovieNotFoundException {
        MovieDto movieById = movieService.findMovieById(movieId);
        return ResponseEntity.ok(apiResponse(movieById));
    }
}
