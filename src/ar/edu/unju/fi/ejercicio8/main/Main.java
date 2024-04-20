package ar.edu.unju.fi.ejercicio8.main;


import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

public class Main {

    
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        CalculadoraEspecial calculadoraEspecial = new CalculadoraEspecial();
        final int limiteSuperior;

        try (scanner) {
            limiteSuperior = ingresarLimiteSuperior("Cargue el límite superior de n en el sistema");  

     
            System.out.println("Resultado Sumatoria es: " + calculadoraEspecial.calcularSumatoria(limiteSuperior));
            System.out.println("Resultado Productoria es: " + calculadoraEspecial.calcularProductoria(limiteSuperior));
        } catch (InputMismatchException e) {
        
            System.out.println("Error: Ocurrió un error en el sistema");
        }
    }

    public static int ingresarLimiteSuperior(final String mensaje) {
        final int limiteSuperior;
       
        System.out.print(mensaje + ": ");
        limiteSuperior = scanner.nextInt();
        scanner.nextLine();

        return limiteSuperior;
    }
}