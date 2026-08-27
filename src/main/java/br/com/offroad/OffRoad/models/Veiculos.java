package br.com.offroad.OffRoad.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculos(@JsonAlias("codigo") String codigoVeiculo,
                       @JsonAlias("nome") String NomeDoVeiculo
                       ){
}
