package com.movie.check.service;

import com.movie.check.configuration.customError.MovieNotFoundException;
import com.movie.check.domain.Screening;
import com.movie.check.repository.screening.ScreeningDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningDao screeningDao;

    public Screening findByScreeningId(Long screeningId) throws MovieNotFoundException {
        return screeningDao.findById(screeningId).orElseThrow(() -> new MovieNotFoundException("선택한 예약시간이 존재하지 않습니다."));
    }

    public void save(Screening screening) {
        screeningDao.save(screening);
    }

}
