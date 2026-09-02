package br.com.offroad.OffRoad.principal;

import br.com.offroad.OffRoad.models.ConverteDados;
import br.com.offroad.OffRoad.models.Montadoras;
import br.com.offroad.OffRoad.models.Veiculos;
import br.com.offroad.OffRoad.services.ChamaApi;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
private String json;
private String modelo;
private String montadora;
private List<Montadoras> montadoras = new ArrayList<>();

    public void exibeMenu() {
        ChamaApi obterDados = new ChamaApi();
        ConverteDados conversor = new ConverteDados();
        Veiculos[] dados = new Veiculos[]{};
        Montadoras dadosMarca = new Montadoras("Feiajo", "Arroz",  montadoras);

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
                json = obterDados.callApiVeiculos("https://parallelum.com.br/fipe/api/v1/carros/marcas");
                dados = conversor.obterDados(json, Veiculos[].class);

                System.out.println("Exibindo todas as montadoras");
                Arrays.stream(dados)
                        .forEach(System.out::println);

                System.out.println("------------------------------------------------------------");
                System.out.println("Digite o código da montadora: ");
                montadora = leitor.nextLine();

                json = obterDados.callApiVeiculos("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + montadora + "/modelos");
                dadosMarca = conversor.obterDados(json, Montadoras.class);
                montadoras.add(dadosMarca);



               List<Montadoras> marcas = montadoras.stream()
                               .flatMap(List::stream)
                                       .collect(Collectors.toList());
                System.out.println(marcas);

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
