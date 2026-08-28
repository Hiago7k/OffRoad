package br.com.offroad.OffRoad.models;

import tools.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        return  mapper.readValue(json, classe);
    }
}
