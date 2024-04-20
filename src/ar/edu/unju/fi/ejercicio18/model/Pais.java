package ar.edu.unju.fi.ejercicio18.model;

public class Pais {
    private static int siguienteCodigo = 0;
    private Integer codigo;
    private String nombre;

    public Pais() {
        ++siguienteCodigo;
        this.codigo = siguienteCodigo;
    }

    public Pais(String nombre) {
        ++siguienteCodigo;
        this.codigo = siguienteCodigo;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return new StringBuilder()
                .append("País").append(":").append("\n")
                .append("Código").append(": ").append(codigo).append("\n")
                .append("Nombre").append(": ").append(nombre).append("\n")
                .toString();
    }
}