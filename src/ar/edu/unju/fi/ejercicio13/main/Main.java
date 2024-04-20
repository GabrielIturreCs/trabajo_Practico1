package ar.edu.unju.fi.ejercicio13.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int vector []=new int [8];
		for (int i=0;i<vector.length; i++) {
	Scanner teclado= new Scanner (System.in);
	System.out.println("Ingrese el valor para el indice : "+i);	
	vector[i]=teclado.nextInt();
		}
		for (int i=0;i<vector.length; i++) {
System.out.println("estoy en el indice: "+i);
	System.out.println("tengo guardado el numero: "+vector[i]);
		}

}}
