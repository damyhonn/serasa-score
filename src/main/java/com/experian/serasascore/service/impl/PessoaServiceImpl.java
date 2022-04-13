package com.experian.serasascore.service.impl;

import com.experian.serasascore.controller.dto.PessoaDTO;
import com.experian.serasascore.controller.dto.PessoaUniqueDTO;
import com.experian.serasascore.controller.form.PessoaForm;
import com.experian.serasascore.model.Pessoa;
import com.experian.serasascore.model.Score;
import com.experian.serasascore.repository.AfinidadeRepository;
import com.experian.serasascore.repository.PessoaRepository;
import com.experian.serasascore.repository.ScoreRepository;
import com.experian.serasascore.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper mapper;
    private final AfinidadeRepository afinidadeRepository;
    private final ScoreRepository scoreRepository;
    private List<Score> scores;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, ModelMapper mapper, AfinidadeRepository afinidadeRepository, ScoreRepository scoreRepository) {
        this.pessoaRepository = pessoaRepository;
        this.mapper = mapper;
        this.afinidadeRepository = afinidadeRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    @Transactional
    public Pessoa savePessoa(final PessoaForm pessoaForm) {
        Pessoa pessoa = mapper.map(pessoaForm, Pessoa.class);
        pessoa.setAfinidade(afinidadeRepository.findByRegiao(pessoaForm.getRegiao()));
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> getPessoa(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public void validateScorePessoas(List<PessoaDTO> pessoas) {
        this.scores = scoreRepository.findAll();
        pessoas.stream().forEach(pessoaDTO -> {
            String descricao = getDescricao(pessoaDTO.getScore());
            pessoaDTO.setScoreDescricao(descricao);
        });
    }

    @Override
    public void validateScorePessoa(PessoaUniqueDTO pessoa) {
        this.scores = scoreRepository.findAll();
        pessoa.setScoreDescricao(getDescricao(pessoa.getScore()));
    }

    private String getDescricao(int score) {
        Collections.sort(this.scores, Comparator.comparingInt(Score::getSFinal));
        for (Score sc: this.scores) {
            if (score <= sc.getSFinal()) {
                return sc.getDescricao();
            }
        }
        return "";
    }
}
