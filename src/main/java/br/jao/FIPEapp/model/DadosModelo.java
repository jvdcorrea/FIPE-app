package br.jao.FIPEapp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelo(
        @JsonAlias("modelos") List<DadosMarca> modelos,
        @JsonAlias("anos") List<DadosMarca> anos
){

}