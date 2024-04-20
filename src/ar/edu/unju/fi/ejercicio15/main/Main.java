package ar.edu.unju.fi.ejercicio15.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int RangoVector;

		do {
			Scanner teclado2= new Scanner (System.in);
			
			System.out.println("Ingrese el espacio del vecto rango permitido de 5 a 10: ");
	RangoVector=teclado2.nextInt();
		} while (RangoVector <= 5 && RangoVector >= 10);
		
		String vector []=new String [RangoVector];
		for (int i=0;i<vector.length; i++) {
			Scanner teclado= new Scanner (System.in);
			System.out.println("Ingrese el nombre para el indice: "+i);	
			vector[i]=teclado.next();
			
				}
				
		for (int i=0;i<vector.length; i++) {
		System.out.println("estoy en el indice: "+i);
			System.out.println("tengo guardado el nombre: "+vector[i]);
				}	
				
				System.out.println("De forma INVERSA");
			
				for (int i=vector.length-1;i>=0; i--) {
					System.out.println("estoy en el indice: "+i);
						System.out.println("tengo guardado el nombre: "+vector[i]);
							}	
	
	}

}
