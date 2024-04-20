package ar.edu.unju.fi.ejercicio6;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona; // Corregir la importación del paquete

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el DNI:");
        String dni = scanner.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento (formato AAAA-MM-DD):");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        
        System.out.println("Ingrese la provincia:");
        String provincia = scanner.nextLine();

        Persona person1 = new Persona(dni, nombre, fechaNacimiento, provincia);
        
        System.out.println("Datos de person1:");
        person1.mostrarDatos();
        System.out.println();

      
        System.out.println("Ingrese el nombre:");
        nombre = scanner.nextLine();
        
        System.out.println("Ingrese el DNI:");
        dni = scanner.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento (formato AAAA-MM-DD):");
        fechaNacimiento = LocalDate.parse(scanner.nextLine());
        
        System.out.println("Ingrese la provincia:");
        provincia = scanner.nextLine();

        Persona personaConParametros = new Persona(dni, nombre, fechaNacimiento, provincia);
        
        System.out.println("Datos de la persona creada con constructor parametrizado:");
        personaConParametros.mostrarDatos();
        System.out.println();


        System.out.println("Ingrese el nombre:");
        nombre = scanner.nextLine();
        
        System.out.println("Ingrese el DNI:");
        dni = scanner.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento (formato AAAA-MM-DD):");
        fechaNacimiento = LocalDate.parse(scanner.nextLine());

        Persona personaConstruidoConDatos = new Persona(dni, nombre, fechaNacimiento);

        System.out.println("Datos de la persona creada con constructor que lleva como parámetros el DNI, nombre y fecha de nacimiento:");
        personaConstruidoConDatos.mostrarDatos();

      
        
    }

}