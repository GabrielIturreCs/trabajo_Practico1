package ar.edu.unju.fi.ejercicio14.main;

import java.util.Scanner;

public class Main {


		


	public static void main(String[] args) {
		int RangoVector;
		int sumaDeVectoresAcumulados=0;
		do {
			Scanner teclado2= new Scanner (System.in);
			
			System.out.println("Ingrese el espacio del vecto rango permitido de 3 a 10: ");
	RangoVector=teclado2.nextInt();
		} while (RangoVector >= 10 && RangoVector <= 3);
			
		int vector []=new int [RangoVector];
			for (int i=0;i<vector.length; i++) {
		Scanner teclado= new Scanner (System.in);
		System.out.println("Ingrese el valor para el indice : "+i);	
		vector[i]=teclado.nextInt();
		sumaDeVectoresAcumulados=sumaDeVectoresAcumulados+vector[i];
			}
			for (int i=0;i<vector.length; i++) {
	System.out.println("estoy en el indice: "+i);
		System.out.println("tengo guardado el numero: "+vector[i]);
			}
			System.out.println("el resultado de la suma es: "+sumaDeVectoresAcumulados);
	}

}
