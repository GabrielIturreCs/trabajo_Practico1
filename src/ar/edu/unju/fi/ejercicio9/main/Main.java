package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Persona;
import ar.edu.unju.fi.ejercicio7.Model.Empleado;
import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 0;

        while (contador < 3) {
    		
    		Scanner scanner = new Scanner(System.in);

        
            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();
            
            System.out.println("Ingrese el codigo:");
  String codigo = scanner.next();
            
            System.out.println("Ingrese precio):");
          int precio = scanner.nextInt();
            
            System.out.println("Ingrese el descuento:");
        int descuento = scanner.nextInt();
    //mi primer objeto
        Producto produ1 = new Producto(nombre, codigo, precio, descuento);
            produ1.mostrarDatos(); // Call mostrarDatos() on each object

            contador++;
        }

        
	}

}
