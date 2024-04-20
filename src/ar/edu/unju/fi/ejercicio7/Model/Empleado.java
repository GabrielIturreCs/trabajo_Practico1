// Clase Empleado
package ar.edu.unju.fi.ejercicio7.Model;

public class Empleado {

    private String nombre;
    private int legajo;
    private double salario;
    private static final float SALARIO_MINIMO = 210000.00f;
    private static final float AUMENTOS = 20000.00f;
    
    // Constructor
    public Empleado(String nombre, int legajo, double salario) {
        this.nombre = nombre;
        this.legajo = legajo;
        if (salario >= SALARIO_MINIMO) {
            this.salario = salario;
        } else {
            this.salario = SALARIO_MINIMO;
        }
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= SALARIO_MINIMO) {
            this.salario = salario+AUMENTOS;
        } else {
            this.salario = SALARIO_MINIMO+AUMENTOS;
        }
    }

    public static float getSalarioMinimo() {
        return SALARIO_MINIMO;
    }

    public static float getAumentos() {
        return AUMENTOS;
    }

    // Método para mostrar los datos del empleado
    public void mostrarDatos() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Legajo: " + this.legajo);
        System.out.println("Salario: " + this.salario);
    }
}
