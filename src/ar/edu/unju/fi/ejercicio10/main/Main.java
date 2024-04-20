package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;
import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("** Pizza " + (i + 1) + " **");

         
            System.out.print("Ingrese el diámetro de la pizza (20, 30 o 40): ");
            float diametro = scanner.nextFloat();
   if (diametro != 20 && diametro != 30 && diametro != 40) {
                System.out.println("El diámetro ingresado no es válido.");
                continue; 
            }

      
            System.out.print("¿La pizza lleva ingredientes especiales? (true/false): ");
            boolean ingredientesEspeciales = scanner.nextBoolean();

    
            Pizza pizza = new Pizza();
            pizza.setDiametro(diametro);
            pizza.setIngredientesEspeciales(ingredientesEspeciales);

          
            pizza.calcularPrecio();
            pizza.calcularArea();

         
            pizza.mostrarDatos();
        }

        scanner.close();
    }
}