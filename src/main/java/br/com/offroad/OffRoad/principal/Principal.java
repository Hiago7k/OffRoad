package br.com.offroad.OffRoad.principal;

import br.com.offroad.OffRoad.models.ConverteDados;
import br.com.offroad.OffRoad.models.Veiculos;
import br.com.offroad.OffRoad.services.ChamaApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
private String json;
    public void exibeMenu() {
        ChamaApi obterDados = new ChamaApi();
        ConverteDados converssor = new ConverteDados();

        System.out.println("****************");
        System.out.println("--- OFF ROAD ---");
        System.out.println("****************");

        Scanner leitor = new Scanner(System.in);
        System.out.println("Escolha uma categoria abaixo");
        System.out.println("carros " + "\nmotos" + "\ncaminhoes");
        System.out.println("Digite o modelo: ");
        String modelo = leitor.nextLine();

        switch (modelo) {
            case "carros":
                System.out.println("caiu em Carro");
                json = obterDados.callApiCarros("https://parallelum.com.br/fipe/api/v1/carros/marcas");
                // isso aqui da certo por que os dado dessa api não estao em uma array de json
                // preciso descobrir como fazer isso de forma correta
                Veiculos[] dados = converssor.obterDados(json, Veiculos[].class);



                System.out.println(json);
                System.out.println(dados);
                // ta dando erro por que essa api, retorna uma lista dentro
                //dessa lista esta os dados

                break;
            case "motos":
                System.out.println("caiu em motos");
                json = obterDados.callApiCarros("https://parallelum.com.br/fipe/api/v1/motos/marcas");
                System.out.println(json);

                break;
            case "caminhoes":
                System.out.println("caiu em Caminhoes");
                json = obterDados.callApiCarros("https://parallelum.com.br/fipe/api/v1/caminhoes/marcas");
                System.out.println(json);

                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
}
