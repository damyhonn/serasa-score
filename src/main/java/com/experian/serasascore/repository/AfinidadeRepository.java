package com.experian.serasascore.repository;

import com.experian.serasascore.model.Afinidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfinidadeRepository extends JpaRepository<Afinidade, Long> {
    Afinidade findByRegiao(String regiao);
}
