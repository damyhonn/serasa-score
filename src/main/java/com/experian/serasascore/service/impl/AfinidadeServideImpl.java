package com.experian.serasascore.service.impl;

import com.experian.serasascore.controller.form.AfinidadeForm;
import com.experian.serasascore.model.Afinidade;
import com.experian.serasascore.repository.AfinidadeRepository;
import com.experian.serasascore.service.AfinidadeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AfinidadeServideImpl implements AfinidadeService {

    private final AfinidadeRepository afinidadeRepository;
    private final ModelMapper mapper;

    public AfinidadeServideImpl(AfinidadeRepository afinidadeRepository, ModelMapper mapper) {
        this.afinidadeRepository = afinidadeRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Afinidade saveAfinidade(AfinidadeForm afinidadeForm) {
        Afinidade afinidade = mapper.map(afinidadeForm, Afinidade.class);
        return afinidadeRepository.save(afinidade);
    }
}
