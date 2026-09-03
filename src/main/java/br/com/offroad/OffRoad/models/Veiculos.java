package br.com.offroad.OffRoad.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculos(@JsonAlias("codigo") String COD,
                       @JsonAlias("nome") String Descricao)
                      {
    @Override
    public String toString() {
        return "Código: " +  COD + " Descrição: " + Descricao;
    }
}
