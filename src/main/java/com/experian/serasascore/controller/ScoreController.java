package com.experian.serasascore.controller;

import com.experian.serasascore.controller.form.ScoreForm;
import com.experian.serasascore.model.Score;
import com.experian.serasascore.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity<Score> save(@RequestBody @Valid ScoreForm score, UriComponentsBuilder uriBuilder) {
        Score saved = scoreService.saveScore(score);
        URI uri = uriBuilder.path("/score/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
