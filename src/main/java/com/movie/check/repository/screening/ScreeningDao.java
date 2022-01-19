package com.movie.check.repository.screening;

import com.movie.check.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningDao extends JpaRepository<Screening, Long> {

}
