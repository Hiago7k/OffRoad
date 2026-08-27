package br.com.offroad.OffRoad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OffRoadApplication  implements SpringApplicationRunListener {

	public static void main(String[] args) {SpringApplication.run(OffRoadApplication.class, args);
		System.out.println("****************");
		System.out.println("--- OFF ROAD ---");
		System.out.println("****************");

		Scanner leitor = new Scanner(System.in);
		System.out.println("Escolha uma categoria abaixo");
		System.out.println("carros " + "\nmotos" + "\ncaminhoes");
		System.out.println("Digite o modelo: ");
		String modelo = leitor.nextLine();
		// carross motos caminhoes

		switch (modelo){
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
