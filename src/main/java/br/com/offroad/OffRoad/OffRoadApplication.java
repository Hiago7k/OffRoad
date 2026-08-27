package br.com.offroad.OffRoad;

import br.com.offroad.OffRoad.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OffRoadApplication implements SpringApplicationRunListener {

    public static void main(String[] args) {
        SpringApplication.run(OffRoadApplication.class, args);

        Principal principal = new Principal();
        principal.exibeMenu();
    }

}
