package com.experian.serasascore.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PessoaForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String nome;
    private String telefone;
    private int idade;
    private String cidade;
    @NotNull @NotEmpty @Length(max = 2)
    private String estado;
    @NotNull @NotEmpty @Length(max = 1000)
    private int score;
    private String regiao;
}
