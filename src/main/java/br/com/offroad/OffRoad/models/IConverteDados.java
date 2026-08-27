package br.com.offroad.OffRoad.models;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
