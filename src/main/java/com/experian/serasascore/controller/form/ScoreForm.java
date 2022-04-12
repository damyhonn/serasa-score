package com.experian.serasascore.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreForm {

    @JsonProperty("scoreDescricao")
    private String descricao;
    @JsonProperty("inicial")
    private int sInicial;
    @JsonProperty("final")
    private int sFinal;
}
