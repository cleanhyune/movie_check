package com.movie.check.controller;

import com.movie.check.domain.Member;
import com.movie.check.domain.Movie;
import com.movie.check.domain.Screening;
import com.movie.check.dto.ApiResponse;
import com.movie.check.service.MemberService;
import com.movie.check.service.MovieService;
import com.movie.check.service.ReservationService;
import com.movie.check.service.ScreeningService;
import com.movie.check.types.Jenre;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.movie.check.dto.ApiResponse.apiResponse;

@RestController
@RequestMapping("/init")
@RequiredArgsConstructor
public class InitController {

    private final MemberService memberService;
    private final MovieService movieService;
    private final ScreeningService screeningService;

    String[] names = {"Joel", "Mikael", "Joly", "haman", "royel", "joseph"};
    String[] movies = {"zootopia", "TENET", "AVATAR", "IRON MAN", "AVENGERS", "LA FRANCE", "BRIDGE OF EDGE"};

    @PutMapping
    public ResponseEntity<ApiResponse> initData() throws NotFoundException {
//        this.generateMember();
//        this.generateMovie();
        this.generateScreening();
        return ResponseEntity.ok(apiResponse("success"));
    }

    public void generateMember() {
        for (String name : names) {
            Member member = Member.builder()
                    .name(name)
                    .build();
            memberService.save(member);
        }
    }

    public void generateMovie() {
        for (String title : movies) {
            Movie movie = Movie.builder()
                    .title(title)
                    .runningTime(LocalTime.of(2, 30))
                    .synopsis(title + "is nice actor")
                    .fee(10000L)
                    .jenre(Jenre.HERO)
                    .openingDate(LocalDate.of(2021, 10, 14))
                    .director("hyune")
                    .build();
            Movie movie2 = Movie.builder()
                    .title(title)
                    .runningTime(LocalTime.of(2, 30))
                    .synopsis(title + "is nice actor")
                    .fee(10000L)
                    .jenre(Jenre.HERO)
                    .openingDate(LocalDate.of(2021, 10, 14))
                    .director("hyune")
                    .build();
            movieService.save(movie2);
        }
    }

    public void generateScreening() throws NotFoundException {
        for(int i=1; i < 7; i++) {
            Movie movie = movieService.getMovieById((long) i);
            Screening screening = Screening.builder()
                    .movie(movie)
                    .runningDay(LocalDate.of(2022, 2, 10))
                    .startTime(LocalTime.of(9, 30))
                    .endTime(LocalTime.of(9, 30).plusHours(movie.getRunningTime().getHour()).plus())
                    .build();
            screeningService.save(screening);
        }

    }

}
