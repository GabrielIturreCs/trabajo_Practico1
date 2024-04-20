package ar.edu.unju.fi.ejercicio12.main;

import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {

	public static void main(String[] args) {
		
		   Scanner scanner = new Scanner(System.in);

	     
	        System.out.print("Ingrese el nombre de la persona: ");
	        String nombre = scanner.nextLine();

	     
	        System.out.println("Ingrese la fecha de nacimiento de la persona (Formato: dd MM yyyy): ");
	        int year = scanner.nextInt();
	        int month = scanner.nextInt() - 1; //  le Reste 1 porque en Calendar los meses van de 0 a 11
	        int day = scanner.nextInt();

	
	        Calendar fechaNacimiento = Calendar.getInstance();
	        fechaNacimiento.set(day, month, year);

	     
	        Persona persona = new Persona(nombre, fechaNacimiento);

	

	        System.out.println(persona.toString());
	        scanner.close();
	}

}
