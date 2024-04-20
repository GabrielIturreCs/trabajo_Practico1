package ar.edu.unju.fi.ejercicio18.main;
import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Pais> paises = new ArrayList<>(); 
 
    static {
        paises.add(new Pais("Argentina")); 
        paises.add(new Pais("Bolivia")); 
        paises.add(new Pais("Brasil")); 
        paises.add(new Pais("Chile")); 
        paises.add(new Pais("Colombia")); 
        paises.add(new Pais("Ecuador")); 
        paises.add(new Pais("Paraguay")); 
        paises.add(new Pais("Perú")); 
        paises.add(new Pais("Uruguay")); 
        paises.add(new Pais("Venezuela")); 
    
    }
    public static void main(String[] args) {
        ArrayList<DestinoTuristico> destinosTuristicos = new ArrayList<>();
        byte opcionSeleccionada;

        try (scanner) {
            do {
                mostrarMenu();
                opcionSeleccionada = ingresarOpcion();
                switch (opcionSeleccionada) {
                case 1 -> agregarDestinoTuristico(destinosTuristicos);
                case 2 -> mostrarTodosLosDestinos(destinosTuristicos);
                case 3 -> editarPaisDeDestinoTuristico(destinosTuristicos);
                case 4 -> limpiarListaDeDestinos(destinosTuristicos);
                case 5 ->  eliminarDestinoTuristicoPorCodigo(
                       destinosTuristicos,
                        getInteger("Ingrese el código del destino turístico a eliminar")
                );
                case 6 -> mostrarDestinosPorNombre(destinosTuristicos);
                case 7 -> mostrarPaises();
                case 8 -> mostrarDestinosPorCodigoDePais(destinosTuristicos);
                case 9 -> System.out.println("Saliendo del menú");
            }
            } while (opcionSeleccionada != 9);

        } catch (InputMismatchException e) {
            mensajeError("Se produjo un error durante la ejecución del programa");
        } finally {
            System.out.println("Fin del programa");
        }
    }

    // Métodos para las opciones del menú

    public static void agregarDestinoTuristico(ArrayList<DestinoTuristico> destinosTuristicos) {
        DestinoTuristico destinoTuristico = new DestinoTuristico();

        System.out.println("Ingrese los datos del nuevo destino turístico");
        ingresarDatosDestinoTuristico(destinoTuristico);
        destinosTuristicos.add(destinoTuristico);
    }

    public static void editarPaisDeDestinoTuristico(ArrayList<DestinoTuristico> destinosTuristicos) {
        if (destinosTuristicos.isEmpty()) {
            mensajeListaVacia();
        } else {
            DestinoTuristico destinoTuristico = obtenerDestinoTuristicoPorCodigo(destinosTuristicos);
            Pais pais = destinoTuristico.getPais();
            System.out.println("Modifique el nombre del país del destino turístico seleccionado");
            ingresarDatosPais(pais);
            System.out.println("El país ha sido modificado");
        }
    }

    public static void mostrarTodosLosDestinos(ArrayList<DestinoTuristico> destinosTuristicos) {
        if (destinosTuristicos.isEmpty()) {
            mensajeListaVacia();
        } else {
            for (DestinoTuristico destinoTuristico : destinosTuristicos) {
                mostrarInformacionDestino(destinoTuristico);
            }
        }
    }

    public static void limpiarListaDeDestinos(ArrayList<DestinoTuristico> destinosTuristicos) {
        destinosTuristicos.clear();
    }

    public static void eliminarDestinoTuristicoPorCodigo(ArrayList<DestinoTuristico> destinosTuristicos, int codigo) {
        if (destinosTuristicos.isEmpty()) {
            mensajeListaVacia();
        } else {
            Iterator<DestinoTuristico> iterador = destinosTuristicos.iterator();
            DestinoTuristico destinoTuristico;
            boolean destinoTuristicoEncontrado = false;

            while (iterador.hasNext()) {
                destinoTuristico = iterador.next();
                if (destinoTuristico.getCodigo() == codigo) { 
                    iterador.remove();
                    destinoTuristicoEncontrado = true;
                }
            }

            if (!destinoTuristicoEncontrado) {
                mensajeDestinoNoEncontrado(codigo);
            } else {
                mensajeDestinoEliminado(codigo);
            }
        }
    }

    public static void mostrarDestinosPorNombre(ArrayList<DestinoTuristico> destinosTuristicos) {
        if (destinosTuristicos.isEmpty()) {
            mensajeListaVacia();
        } else {
            destinosTuristicos.sort(Comparator.comparing(DestinoTuristico::getNombre));
            for (DestinoTuristico destinoTuristico : destinosTuristicos) {
                mostrarInformacionDestino(destinoTuristico);
            }
        }
    }

    public static void mostrarDestinosPorCodigoDePais(ArrayList<DestinoTuristico> destinosTuristicos) {
        if (destinosTuristicos.isEmpty()) {
            mensajeListaVacia();
        } else {
            Pais paisEncontrado = obtenerPaisPorCodigo("Ingrese el código del país");
            int contador = 0;
            for (DestinoTuristico destinoTuristico : destinosTuristicos) {
                if (destinoTuristico.getPais().equals(paisEncontrado)) {
                    mostrarInformacionDestino(destinoTuristico);
                    ++contador;
                }
            }

            if (contador == 0) {
                System.out.printf("No se encontraron destinos turísticos asociados al país %s%n", paisEncontrado.getNombre());
            }
        }
    }

    // Otros métodos auxiliares

    public static void ingresarDatosDestinoTuristico(DestinoTuristico destinoTuristico) {
        destinoTuristico.setNombre(getString("Introduce el nombre"));
        destinoTuristico.setPrecio(getDouble("Introduce el precio"));
        destinoTuristico.setCantidadDeDias(getInteger("Introduce la cantidad de días"));
        destinoTuristico.setPais(obtenerPaisPorCodigo("Ingrese el código del país"));
    }

    public static void ingresarDatosPais(Pais pais) {
        pais.setNombre(getString("Introduce el nombre"));
    }

    public static DestinoTuristico obtenerDestinoTuristicoPorCodigo(ArrayList<DestinoTuristico> destinosTuristicos) {
        int codigoDestinoTuristico;

        while (true) {
            codigoDestinoTuristico = getInteger("Ingresar código del destino turístico");

            if (buscarDestinoTuristicoPorCodigo(destinosTuristicos, codigoDestinoTuristico)) {
                return destinosTuristicos.get(codigoDestinoTuristico - 1);
            } else {
                mensajeError("El código ingresado no corresponde a ningún destino turístico registrado, intente una vez más");
            }
        }
    }

    public static boolean buscarDestinoTuristicoPorCodigo(ArrayList<DestinoTuristico> destinosTuristicos, final int codigo) {
        for (DestinoTuristico destinoTuristico : destinosTuristicos) {
            if (destinoTuristico.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static Pais obtenerPaisPorCodigo(String mensaje) {
        int codigoPais;

        while (true) {
            mostrarPaises();
            codigoPais = getInteger(mensaje);

            if (buscarPaisPorCodigo(codigoPais)) {
                return paises.get(codigoPais - 1);
            } else {
                mensajeError("El código ingresado no corresponde a ningún país registrado");
            }
        }
    }

    public static boolean buscarPaisPorCodigo(final int codigo) {
        for (Pais pais : paises) {
            if (pais.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarPaises() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Lista de países").append("\n");
        for (Pais pais : paises) {
            stringBuilder
                    .append(pais.getCodigo())
                    .append(" - ")
                    .append(pais.getNombre())
                    .append("\n");
        }

        System.out.print(stringBuilder);
    }

    public static void mostrarMenu() {
        System.out.print("""
                ----- MENÚ -----
                1 - Alta de destino turístico
                2 - Mostrar todos los destinos turísticos
                3 - Modificar el país de un destino turístico
                4 - Borrar todos los destinos turísticos
                5 - Eliminar un destino turístico
                6 - Mostrar los destinos turísticos ordenados por nombre
                7 - Mostrar todos los países
                8 - Mostrar los destinos turísticos que pertenecen a un país
                9 - Salir
                """);
    }

    public static void mostrarInformacionDestino(DestinoTuristico destinoTuristico) {
        System.out.print(destinoTuristico.toString());
    }

    public static String getString(final String mensaje) {
        mensajeEntrada(mensaje);
        return scanner.nextLine();
    }

    public static int getInteger(final String mensaje) {
        int valorEntero;

        while (true) {
            mensajeEntrada(mensaje);
            try {
                valorEntero = Integer.parseInt(scanner.nextLine());
                return valorEntero;
            } catch (NumberFormatException e) {
                mensajeError("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static double getDouble(final String mensaje) {
        double valorDecimal;

        while (true) {
            mensajeEntrada(mensaje);
            try {
                valorDecimal = Double.parseDouble(scanner.nextLine());
                return valorDecimal;
            } catch (NumberFormatException e) {
                mensajeError("El valor ingresado debe ser un número");
            }
        }
    }

    public static byte ingresarOpcion() {
        byte opcionSeleccionada;

        while (true) {
            try {
                mensajeEntrada("Seleccione una opción");
                opcionSeleccionada = Byte.parseByte(scanner.nextLine());
                return opcionSeleccionada;
            } catch (NumberFormatException e) {
                mensajeError("Solo se permite el ingreso de números");
            }
        }
    }



    public static void mensajeEntrada(final String mensaje) {
        System.out.print(mensaje + ": ");
    }

    private static void mensajeError(final String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    public static void mensajeListaVacia() {
        System.out.println("ERROR: La lista de destinos turísticos se encuentra vacía");
    }

    public static void mensajeDestinoEliminado(final int codigo) {
        System.out.printf("Se eliminó el destino turístico con el código n.º %d de la lista de destinos turísticos%n", codigo);
    }

    public static void mensajeDestinoNoEncontrado(final int codigo) {
        System.out.printf("ERROR: El destino turístico con el código n.º %d no se encuentra en la lista de destinos turísticos%n", codigo);
    }
}