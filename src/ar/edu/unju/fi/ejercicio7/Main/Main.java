package ar.edu.unju.fi.ejercicio7.Main;

import java.util.Scanner;
import ar.edu.unju.fi.ejercicio7.Model.Empleado;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el legajo:");
        int legajo = scanner.nextInt();

        System.out.println("Ingrese salario:");
        double salario = scanner.nextDouble();

        // Crear instancia de Empleado con los valores ingresados por el usuario
        Empleado empleado1 = new Empleado(nombre, legajo, salario);
        
        System.out.println("Datos del empleado:");
        empleado1.mostrarDatos();
    }
}