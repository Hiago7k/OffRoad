package br.com.offroad.OffRoad.principal;

import br.com.offroad.OffRoad.models.ConverteDados;
import br.com.offroad.OffRoad.models.DadosCarros;
import br.com.offroad.OffRoad.models.Veiculos;
import br.com.offroad.OffRoad.services.ChamaApi;

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
                DadosCarros dados = converssor.obterDados(json, DadosCarros.class);
                System.out.println(json);
                System.out.println(dados);

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
