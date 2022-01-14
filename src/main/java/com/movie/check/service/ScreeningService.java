package com.movie.check.service;

import com.movie.check.domain.Screening;
import org.springframework.stereotype.Service;

@Service
public class ScreeningService {

    public Screening findByScreeningId(Long screeningId) {
        return new Screening();
    }

}
