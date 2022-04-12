package com.experian.serasascore.controller;

import com.experian.serasascore.controller.form.AfinidadeForm;
import com.experian.serasascore.model.Afinidade;
import com.experian.serasascore.service.AfinidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/afinidade")
public class AfinidadeController {

    private final AfinidadeService afinidadeService;

    public AfinidadeController(AfinidadeService afinidadeService) {
        this.afinidadeService = afinidadeService;
    }

    @PostMapping
    public ResponseEntity<Afinidade> save(@RequestBody @Valid AfinidadeForm afinidadeForm,
                                          UriComponentsBuilder uriBuilder) {
        Afinidade afinidade = afinidadeService.saveAfinidade(afinidadeForm);
        URI uri = uriBuilder.path("afinidade/{id}").buildAndExpand(afinidade.getId()).toUri();
        return ResponseEntity.created(uri).body(afinidade);
    }
}
