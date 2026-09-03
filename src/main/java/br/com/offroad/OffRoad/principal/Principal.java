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
        Veiculos[] dados2 = new Veiculos[]{};
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

                // depois digite código do carro
                // Retorna todos os anos que tenha cadastrado na tabela fip  eo valor

                System.out.println("Digite o código de um carro que deseja saber mais: ");
                codigoVeiculo = leitor.nextLine();

                endereco =  URL_API + "carros/marcas/" + montadora + "/modelos/" + codigoVeiculo + "/anos/";
                json = obterDados.callApiVeiculos(endereco);
                System.out.println(json);
               // dados2 = conversor.obterDados(endereco, Veiculos[].class);
                System.out.println("*********");

                Arrays.stream(dados2)
                        .forEach(System.out::println);



                // agrupar todos os anos e valor de uma so vez para exibir
                // quando chamar ja agrupa todos os anos
                // por que  sao 2 apis uma pra amarzenar os anos
                // outra para exibir os valores e etc do ano em especifico
                // fazer uma iteracao dentro de outra
                // exemplo Veiculo [Valor=R$ 15k] marca=Fiat, modelo = Pailo, ano 2003, combustivel
                // exemplo Veiculo [Valor=R$ 13k] marca=Fiat, modelo = Pailo, ano 2003, combustivel


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
