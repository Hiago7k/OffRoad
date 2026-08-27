package br.com.offroad.OffRoad.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Veiculos(@JsonAlias("codigo") String codigoVeiculo,
                       @JsonAlias("nome") String NomeDoVeiculo
                       ){
}
