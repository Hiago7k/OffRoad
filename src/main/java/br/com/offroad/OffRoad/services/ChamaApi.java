package br.com.offroad.OffRoad.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChamaApi {

    public String callApiCarros(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request  = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = null;
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e ){
            throw  new RuntimeException(e);
        }
        String json = response.body();
        return json;
    };

    public void callApiMotos(){
        System.out.println("Lógica para chamar API aqui dentro");

    };

    public void callApiCaminhoes(){
        System.out.println("Lógica para chamar API aqui dentro");

    };
}
