package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Persona;

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
//mi primer objeto
        Persona objeto1pordefecto = new Persona(dni, nombre, fechaNacimiento, provincia);
        
        System.out.println("Datos de person1:");
        objeto1pordefecto.mostrarDatos();
        System.out.println();

      
        System.out.println("Ingrese el nombre:");
        nombre = scanner.nextLine();
        
        System.out.println("Ingrese el DNI:");
        dni = scanner.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento (formato AAAA-MM-DD):");
        fechaNacimiento = LocalDate.parse(scanner.nextLine());
        
        System.out.println("Ingrese la provincia:");
        provincia = scanner.nextLine();

        Persona objeto2ConParametros = new Persona(dni, nombre, fechaNacimiento, provincia);
        // Crear el segundo objeto //
        // Mostrar los datos 
        System.out.println("Datos de la persona creada con constructor parametrizado:");
        objeto2ConParametros.mostrarDatos();
        System.out.println();


        System.out.println("Ingrese el nombre:");
        nombre = scanner.nextLine();
        
        System.out.println("Ingrese el DNI:");
        dni = scanner.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento (formato AAAA-MM-DD):");
        fechaNacimiento = LocalDate.parse(scanner.nextLine());

        Persona miobjeto3ConstruidoConDatos = new Persona(dni, nombre, fechaNacimiento);

        // Persona que lleva como parámetros el DNI, nombre y fecha de nacimiento o  objeto 3 
        System.out.println("Datos de la persona creada con constructor que lleva como parámetros el DNI, nombre y fecha de nacimiento:");
        miobjeto3ConstruidoConDatos.mostrarDatos();

        scanner.close();
		
	}

}
