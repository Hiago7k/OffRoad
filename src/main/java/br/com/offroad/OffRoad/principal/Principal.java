package br.com.offroad.OffRoad.principal;

import java.util.Scanner;

public class Principal {

    public void exibeMenu() {
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
                break;
            case "motos":
                System.out.println("caiu em motos");
                break;
            case "caminhoes":
                System.out.println("caiu em Caminhoes");
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
}
