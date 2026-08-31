package br.com.offroad.OffRoad.principal;

import br.com.offroad.OffRoad.models.ConverteDados;
import br.com.offroad.OffRoad.models.Montadoras;
import br.com.offroad.OffRoad.models.Veiculos;
import br.com.offroad.OffRoad.services.ChamaApi;

import java.util.*;

public class Principal {
private String json;
private String modelo;
private String montadora;
private List<Montadoras> montadoras = new ArrayList<>();

    public void exibeMenu() {
        ChamaApi obterDados = new ChamaApi();
        ConverteDados conversor = new ConverteDados();
        Veiculos[] dados = new Veiculos[]{};
      //  Montadoras dadosMarca = new Montadoras{};
        Object Montadoras = null;
        Montadoras dadosMarca = new Montadoras("", "",  montadoras);

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
                System.out.println(json); // a chamada de api esta okay, o problema e quando
                    // fazemos a desrealizacao do json para java


//                dadosMarca = conversor.obterDados(json, Montadoras.class);
//                List<Montadoras> dadosMontadroas = new ArrayList<>();
//                dadosMontadroas.add(dadosMarca);
//
//                for(var zum : dadosMontadroas){
//                    System.out.println(zum);
//                }


                //{"modelos":[{"codigo":11920,"nome":"Atto 8 1.5 16V Aut."},{"codigo":9902,"nome":"D1 EV (Elétrico)"}
                // ele ta pegando esse objeto primeiro "modelos"


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
