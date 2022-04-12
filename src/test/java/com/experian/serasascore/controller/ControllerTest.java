package com.experian.serasascore.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveRetornar204NoContentParaBuscaPorId() throws Exception {
        URI uri = new URI("/pessoa/15");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    public void deveRetornar204NoContentParaBuscaDePessoas() throws Exception {
        URI uri = new URI("/pessoa");

        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NO_CONTENT.value()));
    }

    @Test
    public void deveRetornar201CreatedParaInsercaoDePessoa() throws Exception {
        URI uri = new URI("/pessoa");
        String json = "{\n" +
                "    \"nome\": \"Sicrano de tal\",\n" +
                "    \"telefone\": \"99 99999-9999\",\n" +
                "    \"idade\": 27,\n" +
                "    \"cidade\": \"João Pessoa\",\n" +
                "    \"estado\": \"PB\",\n" +
                "    \"score\": 701,\n" +
                "    \"regiao\": \"sudeste\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));
    }

    @Test
    public void deveRetornarPessoaAoBuscarPorUmaInserida() throws Exception {
        URI uriPostPessoa = new URI("/pessoa");
        URI uriGetPessoa = new URI("/pessoa/1");
        URI uriAfinidade = new URI("/afinidade");
        URI uriScore1 = new URI("/score");
        URI uriScore2 = new URI("/score");
        URI uriScore3 = new URI("/score");
        URI uriScore4 = new URI("/score");

        String jsonPessoa = "{\n" +
                "    \"nome\": \"Sicrano de tal\",\n" +
                "    \"telefone\": \"99 99999-9999\",\n" +
                "    \"idade\": 27,\n" +
                "    \"cidade\": \"São Paulo\",\n" +
                "    \"estado\": \"SP\",\n" +
                "    \"score\": 701,\n" +
                "    \"regiao\": \"sudeste\"\n" +
                "}";

        String jsonAfinidade = "{\n" +
                "    \"regiao\": \"sudeste\",\n" +
                "    \"estados\": [\n" +
                "        \"SP\",\n" +
                "        \"RJ\",\n" +
                "        \"MG\",\n" +
                "        \"ES\"\n" +
                "    ]\n" +
                "}";

        String jsonScore1 = "{\n" +
                "    \"scoreDescricao\": \"Insuficiente\",\n" +
                "    \"inicial\": 0,\n" +
                "    \"final\": 200\n" +
                "}";

        String jsonScore2 = "{\n" +
                "    \"scoreDescricao\": \"Inaceitável\",\n" +
                "    \"inicial\": 201,\n" +
                "    \"final\": 500\n" +
                "}";

        String jsonScore3 = "{\n" +
                "    \"scoreDescricao\": \"Aceitável\",\n" +
                "    \"inicial\": 501,\n" +
                "    \"final\": 700\n" +
                "}";

        String jsonScore4 = "{\n" +
                "    \"scoreDescricao\": \"Recomendável\",\n" +
                "    \"inicial\": 701,\n" +
                "    \"final\": 1000\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uriAfinidade)
                        .content(jsonAfinidade)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uriScore1)
                        .content(jsonScore1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uriScore2)
                        .content(jsonScore2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uriScore3)
                        .content(jsonScore3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uriScore4)
                        .content(jsonScore4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uriPostPessoa)
                        .content(jsonPessoa)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get(uriGetPessoa))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}
