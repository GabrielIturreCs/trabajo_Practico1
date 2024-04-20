package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	  System.out.println("Ingrese un numero del 1 al 9");
      	try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Ingrese un numero para calcular la tabla: ");
			  int Entero = scanner.nextInt();
			  if (Entero >= 1 && Entero <= 9) {
	                System.out.println("La tabla de multiplicación de " + Entero + " es:");
int Multiplicacion=Entero;        
for (int i = 0; i <= 10; i++) {
				Multiplicacion=Entero*i;
				
				System.out.println("La tabla es: "+Multiplicacion);
				
}
			  }
else {
	System.out.println("el numero no esta en el rango");
}
			
		}
    }
}