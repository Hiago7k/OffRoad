package br.com.offroad.OffRoad.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Montadoras<Modelos>(@JsonAlias("codigo") String codigoMarca,
                                  @JsonAlias("nome") String nomeMarca,
                                  @JsonAlias("modelos") List<Modelos> Modelo
                         ){

}
