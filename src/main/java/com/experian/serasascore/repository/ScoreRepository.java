package com.experian.serasascore.repository;

import com.experian.serasascore.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
