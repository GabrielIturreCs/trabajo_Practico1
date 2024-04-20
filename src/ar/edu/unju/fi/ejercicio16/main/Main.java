package ar.edu.unju.fi.ejercicio16.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		        Scanner teclado = new Scanner(System.in);

		        String[] vector = new String[5];


		        for (int i = 0; i < vector.length; i++) {
		            System.out.println("Ingrese el nombre para el índice " + i + ":");
		            vector[i] = teclado.nextLine();
		        }

		        System.out.println("Elementos del arreglo:");
		        int j = 0;
		        while (j < vector.length) {
		            System.out.println(vector[j]);
		            j++;
		        }

		        System.out.println("Tamaño del arreglo: " + vector.length);

		        byte indiceEliminar;
		        do {
		            System.out.println("Ingrese el índice del elemento a eliminar (entre 0 y " + (vector.length - 1) + "):");
		            indiceEliminar = teclado.nextByte();
		            if (indiceEliminar < 0 || indiceEliminar >= vector.length) {
		                System.out.println("Índice fuera de rango. Inténtelo nuevamente.");
		            }
		        } while (indiceEliminar < 0 || indiceEliminar >= vector.length);

		        for (int k = (int) indiceEliminar; k < vector.length - 1; k++) {
		            vector[k] = vector[k + 1];
		        }
		        vector[vector.length - 1] = null; 

		        System.out.println("Arreglo después de eliminar el elemento:");
		        for (String nombre : vector) {
		            System.out.println(nombre);
		        }
		    }
		}