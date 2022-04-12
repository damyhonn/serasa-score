package com.experian.serasascore.service.impl;

import com.experian.serasascore.controller.form.ScoreForm;
import com.experian.serasascore.model.Score;
import com.experian.serasascore.repository.ScoreRepository;
import com.experian.serasascore.service.ScoreService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final ModelMapper mapper;

    public ScoreServiceImpl(ScoreRepository scoreRepository, ModelMapper mapper) {
        this.scoreRepository = scoreRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    @CacheEvict(value = "scoreList", allEntries = true)
    public Score saveScore(ScoreForm scoreForm) {
        Score score = mapper.map(scoreForm, Score.class);
        return scoreRepository.save(score);
    }

    @Cacheable(value = "scoreList")
    public List<Score> listScores() {
        return scoreRepository.findAll();
    }
}
