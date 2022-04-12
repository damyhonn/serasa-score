package com.experian.serasascore.controller.dto;

import com.experian.serasascore.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PessoaUniqueDTO {
    private String nome;
    private String telefone;
    private int idade;
    @JsonIgnore
    private int score;
    private String scoreDescricao;
    private List<String> estados;

    public PessoaUniqueDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
        this.idade = pessoa.getIdade();
        this.score = pessoa.getScore();
        this.estados = pessoa.getAfinidade() != null ? pessoa.getAfinidade().getEstados() : null;
    }

    public static PessoaUniqueDTO convert(Pessoa pessoa) {
        return new PessoaUniqueDTO(pessoa);
    }
}
