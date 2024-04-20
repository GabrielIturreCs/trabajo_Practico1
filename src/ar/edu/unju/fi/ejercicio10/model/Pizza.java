package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
private float diametro;
private float precio;
private float  area;
private boolean IngredientesEspeciales;
public static final int precio_especial_20 = 500;
public static final int precio_especial_30 = 750;
public static final int precio_especial_40 = 1000;


public Pizza() {
}

public float getDiametro() {
    return diametro;
}

public void setDiametro(float diametro) {
    this.diametro = diametro;
}

public float getPrecio() {
    return precio;
}

public void setPrecio(float precio) {
    this.precio = precio;
}

public float getArea() {
    return area;
}

public void setArea(float area) {
    this.area = area;
}

public boolean isIngredientesEspeciales() {
    return IngredientesEspeciales;
}

public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
    this.IngredientesEspeciales = ingredientesEspeciales;
}

public static int getPrecioEspecial20() {
    return precio_especial_20;
}

public static int getPrecioEspecial30() {
    return precio_especial_30;
}

public static int getPrecioEspecial40() {
    return precio_especial_40;
}


public void calcularPrecio() {
    if (diametro == 20 || diametro >=20) {
        if (IngredientesEspeciales)
            precio = 4500 + precio_especial_20;
        else
            precio = 4500;
    } else if (diametro == 30) {
        if (IngredientesEspeciales)
            precio = 4800 + precio_especial_30;
        else
            precio = 4800;
    } else if (diametro == 40) {
        if (IngredientesEspeciales)
            precio = 5500 + precio_especial_40;
        else
            precio = 5500;
    } else {
        System.out.println("Diámetro no válido.");
    }
}


public void calcularArea() {
    float radio = diametro / 2;
    area = (float) (Math.PI * radio * radio);
}

public void mostrarDatos() {
    System.out.println("Diametro: " + diametro);
    System.out.println("Precio: $" + precio);
    System.out.println("Área: " + area);
    System.out.println("Ingredientes Especialess: " + (IngredientesEspeciales ? "Sí" : "No"));
}
}


