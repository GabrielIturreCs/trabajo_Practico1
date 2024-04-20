package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	  System.out.println("El numero deber estar entre 0 y 10");
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero para calcular su factorial: ");

        int Entero = scanner.nextInt();

      

        if (Entero >= 0 && Entero <= 10) {
            int contador = Entero - 1;
            while (contador != 1) {
                Entero = Entero * contador;
                contador = contador - 1;
            }
            System.out.println("EL RESULTADO ES: " + Entero);
        } else {
            System.out.println("El numero no cumple con los requisitos.");
        }

        scanner.close();
    }
}