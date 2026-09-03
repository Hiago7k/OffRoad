package br.com.offroad.OffRoad.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FichaTecnicaVeiculos(@JsonAlias("Valor") String valor,
                                   @JsonAlias("Marca") String marca,
                                   @JsonAlias("Modelo") String modelo,
                                   @JsonAlias("AnoModelo") Integer ano,
                                   @JsonAlias("Combustivel") String combustivel,
                                   @JsonAlias("CodigoFipe") String codFipe
                                   ) {
}
