package com.experian.serasascore.service;

import com.experian.serasascore.controller.form.PessoaForm;
import com.experian.serasascore.model.Pessoa;

import java.util.List;

public interface PessoaService {
    Pessoa savePessoa(PessoaForm pessoaForm);
    Pessoa getPessoa(Long id);
    List<Pessoa> getPessoas();
}
