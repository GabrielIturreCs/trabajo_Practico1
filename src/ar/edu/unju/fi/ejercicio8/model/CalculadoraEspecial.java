package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
    private Integer num;

    public CalculadoraEspecial() {
    }

    public Integer getNumero() {
        return num;
    }

    public void setNumero(Integer num) {
        this.num = num;
    }


    public int calcularSumatoria(final int n) {
        int sumatoria = 0, numerador;
        final int denominador = 2;

        for (int k = 1; k <= n; k++) {
            numerador = k * (k+1);
            sumatoria += (int) Math.pow(((double) numerador / denominador), 2);
        }

        return sumatoria;
    }


    public int calcularProductoria(final int n) {
        int product = 1;

        for (int k = 1; k <= n; k++) {
            product *= k * (k+4);
        }

        return product;
    }
}