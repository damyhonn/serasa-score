package com.experian.serasascore.controller;

import com.experian.serasascore.controller.dto.PessoaDTO;
import com.experian.serasascore.controller.dto.PessoaUniqueDTO;
import com.experian.serasascore.controller.form.PessoaForm;
import com.experian.serasascore.model.Pessoa;
import com.experian.serasascore.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> getAll() {
        List<Pessoa> pessoas = pessoaService.getPessoas();
        if (pessoas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<PessoaDTO> list = PessoaDTO.convert(pessoas);
        pessoaService.validateScorePessoas(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaUniqueDTO> getPessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.getPessoa(id);
        if (pessoa.isPresent()) {
            PessoaUniqueDTO p = PessoaUniqueDTO.convert(pessoa.get());
            pessoaService.validateScorePessoa(p);
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> save(@RequestBody @Valid PessoaForm pessoaForm,
                                                UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = pessoaService.savePessoa(pessoaForm);
        URI uri = uriBuilder.path("pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
