package com.experian.serasascore.service;

import com.experian.serasascore.controller.form.AfinidadeForm;
import com.experian.serasascore.model.Afinidade;

public interface AfinidadeService {
    Afinidade saveAfinidade(AfinidadeForm afinidade);
}
