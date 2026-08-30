package br.com.offroad.OffRoad.principal;

import br.com.offroad.OffRoad.models.ConverteDados;
import br.com.offroad.OffRoad.models.Veiculos;
import br.com.offroad.OffRoad.services.ChamaApi;

import java.util.*;

public class Principal {
private String json;
private String modelo;
private String montadora;

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
        modelo = leitor.nextLine();

        switch (modelo) {
            case "carros":
                System.out.println("caiu em Carro");
                json = obterDados.callApiVeiculos("https://parallelum.com.br/fipe/api/v1/carros/marcas");
                Veiculos[] dados = converssor.obterDados(json, Veiculos[].class);

                System.out.println("Exibindo todas as montadoras");
                Arrays.stream(dados)
                        .forEach(System.out::println);

//
//                System.out.println("Digite a marca que deseja procurar: ");
//                montadora = leitor.nextLine();
//                System.out.println("Exibindo todos os veículos da montadora");
//                Veiculos[] dadosCarrosMarcas = converssor.obterDados(json, Veiculos[].class);
//                String pesquisa = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + montadora + "/modelos";
//                json = obterDados.callApiVeiculos(pesquisa);
//                System.out.println("---------------");
//                for(var dadosMarcas : dadosCarrosMarcas){
//                    System.out.println(dadosMarcas);
//                }

                break;
            case "motos":
                System.out.println("caiu em motos");
                json = obterDados.callApiVeiculos("https://parallelum.com.br/fipe/api/v1/motos/marcas");
                System.out.println(json);

                break;
            case "caminhoes":
                System.out.println("caiu em Caminhoes");
                json = obterDados.callApiVeiculos("https://parallelum.com.br/fipe/api/v1/caminhoes/marcas");
                System.out.println(json);

                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
}
