package br.com.offroad.OffRoad.models;

import tools.jackson.databind.DeserializationConfig;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {

    private final ObjectMapper mapper = new ObjectMapper();

   // ObjectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true)

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        return  mapper.readValue(json, classe);
    }
}
