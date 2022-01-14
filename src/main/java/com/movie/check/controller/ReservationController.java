package com.movie.check.controller;

import com.movie.check.domain.Member;
import com.movie.check.domain.Screening;
import com.movie.check.dto.ApiResponse;
import com.movie.check.service.ReservationService;
import com.movie.check.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.movie.check.dto.ApiResponse.apiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final ScreeningService screeningService;

    @PutMapping("/{screeningId}")
    public ResponseEntity<ApiResponse> reservationMovie(
            @PathVariable("screeningId") Long screeningId,
            @RequestParam("adultCount") Long adultCount,
            @RequestParam("childCount") Long childCount,
            Member member
    ) {
        Screening screening = screeningService.findByScreeningId(screeningId);
        reservationService.reserve(screening, member, adultCount, childCount);
        return ResponseEntity.ok(apiResponse("success"));
    }

}
