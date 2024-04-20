package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Ingrese un numero entero");
		 int Entero=scanner.nextInt();	
	
	if (Entero%2==0) {
		Entero=Entero*2;
		System.out.println("El numero es par y se multiplica por dos: "+Entero);
	}
	else {
		Entero=Entero*3;
	System.out.println("El numero es impar y se multiplica por tres: "+Entero);  
	}
	
	}

	 
}
