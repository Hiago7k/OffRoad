package br.com.offroad.OffRoad.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Montadoras(@JsonAlias("codigo") String codigoMarca,
                         @JsonAlias("nome") String nomeMarca
                         ){
}
