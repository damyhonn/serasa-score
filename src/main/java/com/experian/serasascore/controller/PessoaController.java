package com.experian.serasascore.controller;

import com.experian.serasascore.controller.dto.PessoaDTO;
import com.experian.serasascore.controller.form.PessoaForm;
import com.experian.serasascore.model.Pessoa;
import com.experian.serasascore.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;
    private final ModelMapper mapper;

    public PessoaController(PessoaService pessoaService, ModelMapper mapper) {
        this.pessoaService = pessoaService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> getPessoas() {
        List<Pessoa> pessoas = pessoaService.getPessoas();
        if (pessoas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(PessoaDTO.convert(pessoas));
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> postPessoa(@RequestBody @Valid PessoaForm pessoaForm,
                                                UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = pessoaService.savePessoa(pessoaForm);
        URI uri = uriBuilder.path("pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.map(pessoa, PessoaDTO.class));
    }
}
