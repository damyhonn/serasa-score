package com.experian.serasascore.service;

import com.experian.serasascore.controller.dto.PessoaDTO;
import com.experian.serasascore.controller.dto.PessoaUniqueDTO;
import com.experian.serasascore.controller.form.PessoaForm;
import com.experian.serasascore.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    Pessoa savePessoa(PessoaForm pessoaForm);
    Optional<Pessoa> getPessoa(Long id);
    List<Pessoa> getPessoas();
    void validateScorePessoas(List<PessoaDTO> pessoas);
    void validateScorePessoa(PessoaUniqueDTO pessoa);
}
