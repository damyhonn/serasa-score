package com.experian.serasascore.service;

import com.experian.serasascore.controller.form.ScoreForm;
import com.experian.serasascore.model.Score;

public interface ScoreService {
    Score saveScore(ScoreForm score);
}
