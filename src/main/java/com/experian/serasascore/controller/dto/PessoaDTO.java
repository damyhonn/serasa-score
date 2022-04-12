package com.experian.serasascore.controller.dto;

import com.experian.serasascore.model.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PessoaDTO {
    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;
    private List<String> estados;

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.cidade = pessoa.getCidade();
        this.estado = pessoa.getEstado();
        this.estados = pessoa.getAfinidade().getEstados();
    }

    public static List<PessoaDTO> convert(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
    }
}
