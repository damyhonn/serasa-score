package com.experian.serasascore.service.impl;

import com.experian.serasascore.controller.form.PessoaForm;
import com.experian.serasascore.model.Pessoa;
import com.experian.serasascore.repository.AfinidadeRepository;
import com.experian.serasascore.repository.PessoaRepository;
import com.experian.serasascore.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper mapper;
    private final AfinidadeRepository afinidadeRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, ModelMapper mapper, AfinidadeRepository afinidadeRepository) {
        this.pessoaRepository = pessoaRepository;
        this.mapper = mapper;
        this.afinidadeRepository = afinidadeRepository;
    }

    @Override
    @Transactional
    public Pessoa savePessoa(final PessoaForm pessoaForm) {
        Pessoa pessoa = mapper.map(pessoaForm, Pessoa.class);
        pessoa.setAfinidade(afinidadeRepository.findByRegiao(pessoaForm.getRegiao()));
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa getPessoa(Long id) {
        return pessoaRepository.getById(id);
    }

    @Override
    public List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        validaScorePessoas(pessoas);
        return pessoas;
    }

    private void validaScorePessoas(List<Pessoa> pessoas) {

    }
}
