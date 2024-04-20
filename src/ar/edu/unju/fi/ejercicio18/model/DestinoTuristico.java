package ar.edu.unju.fi.ejercicio18.model;

public class DestinoTuristico {
    private static int siguienteCodigo = 0;
    private Integer codigo;
    private String nombre;
    private Double precio;
    private Pais pais;
    private Integer cantidadDeDias;

    public DestinoTuristico() {
        ++siguienteCodigo;
        this.codigo = siguienteCodigo;
    }

    public DestinoTuristico(String nombre, Double precio, Pais pais, Integer cantidadDeDias) {
        ++siguienteCodigo;
        this.codigo = siguienteCodigo;
        this.nombre = nombre;
        this.precio = precio;
        this.pais = pais;
        this.cantidadDeDias = cantidadDeDias;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Integer getCantidadDeDias() {
        return cantidadDeDias;
    }

    public void setCantidadDeDias(Integer cantidadDeDias) {
        this.cantidadDeDias = cantidadDeDias;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Destino Turístico").append(":").append("\n")
                .append("Código").append(": ").append(codigo).append("\n")
                .append("Nombre").append(": ").append(nombre).append("\n")
                .append("Precio").append(": ").append(precio).append("\n")
                .append(pais)
                .append("Cantidad de días").append(": ").append(cantidadDeDias).append("\n")
                .toString();
    }
}