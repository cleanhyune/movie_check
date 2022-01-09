package com.movie.check.repository.movie;

import com.movie.check.domain.Movie;
import com.movie.check.dto.MovieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, CustomMovieRepository {

}
