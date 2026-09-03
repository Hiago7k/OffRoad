package br.com.offroad.OffRoad.principal;

import br.com.offroad.OffRoad.models.ConverteDados;
import br.com.offroad.OffRoad.models.Montadoras;
import br.com.offroad.OffRoad.models.Veiculos;
import br.com.offroad.OffRoad.services.ChamaApi;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
private String json;
private String modelo;
private String montadora;
private String trechoVeiculo;
private String codigoVeiculo;
private String regex = "[\\{\\}]";
private final String URL_API = "https://parallelum.com.br/fipe/api/v1/";
private String endereco;
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
        System.out.println("carros " + "\nmotos" + "\ncaminhoes");
        System.out.println("Digite o modelo: ");
        modelo = leitor.nextLine();

        switch (modelo) {
            case "carros" :
                endereco = URL_API + "carros/marcas/";
                json = obterDados.callApiVeiculos(endereco);
                dados = conversor.obterDados(json, Veiculos[].class);

                System.out.println("Exibindo todas as montadoras");
                Arrays.stream(dados)
                        .forEach(System.out::println);

                System.out.println("------------------------------------------------------------");
                System.out.println("Digite o código da montadora: ");
                montadora = leitor.nextLine();
                endereco = URL_API + "carros/marcas/" + montadora + "/modelos/";
                json = obterDados.callApiVeiculos(endereco);
                dadosMarca = conversor.obterDados(json, Montadoras.class);
                montadoras.add(dadosMarca);
                System.out.println("****************************************************************************");
                System.out.println("Exibindo Todos os carros da Montadora: " + montadora);
                 montadoras.stream()
                    .flatMap(l -> l.Modelo().stream())
                         .map(l -> l.toString().toUpperCase().replaceAll(regex, ""))
                         .forEach(System.out::println);

                System.out.println("****************************************************************************");

                System.out.println("Digite o trecho de um veiculo que deseja filtrar: ");
                trechoVeiculo = leitor.nextLine();
                trechoVeiculo = trechoVeiculo.toUpperCase();

                System.out.println("Trazendo todos os registros que possuem " + trechoVeiculo + " na descrição");
                montadoras.stream()
                        .flatMap(l -> l.Modelo().stream())
                        .map(l -> l.toString().toUpperCase().replaceAll(regex, ""))
                        .filter(l -> l.toString().contains(trechoVeiculo))
                        .forEach(System.out::println);

                // retorna os carros que possuem o trecho que ele escreveu
                // depois digite código do carro
                // Retorna todos os anos que tenha cadastrado na tabela fip  eo valor
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
