package com.movie.check.repository.movie;

import com.movie.check.domain.QMovie;
import com.movie.check.dto.MovieDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements CustomMovieRepository {

    private final JPAQueryFactory queryFactory;
    private final QMovie movie = QMovie.movie;
    private final QBean<MovieDto> defaultSelect =
            Projections.fields(MovieDto.class,
                    movie.movieId,
                    movie.title,
                    movie.synopsis,
                    movie.director,
                    movie.jenre,
                    movie.openingDate,
                    movie.runningTime
            );

    @Override
    public List<MovieDto> findMovies() {
        return queryFactory.select(defaultSelect).from(movie).fetch();
    }

    @Override
    public Optional<MovieDto> findMovieById(Long movieId) {
        return Optional.ofNullable(queryFactory.select(defaultSelect).from(movie)
                .where(movie.movieId.eq(movieId)).fetchOne());
    }

}
