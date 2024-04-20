package ar.edu.unju.fi.ejercicio17.main;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        byte opcionSeleccionada;

        try(scanner) {
            do {
                mostrarMenu();
                opcionSeleccionada = ingresarOpcion();

                switch (opcionSeleccionada) {
                    case 1 -> altaJugador(jugadores);
                    case 2 -> mostrarDatosJugador(
                            jugadores,
                            getString("Ingrese nombre"),
                            getString("Ingrese apellido")
                    );
                    case 3 -> mostrarJugadoresOrdenadosPorApellido(jugadores);
                    case 4 -> modificarDatosJugador(
                            jugadores,
                            getString("Ingrese nombre"),
                            getString("Ingrese apellido")
                    );
                    case 5 -> eliminarJugadorPorNombreCompleto(
                            jugadores,
                            getString("Ingrese nombre"),
                            getString("Ingrese apellido")
                    );
                    case 6 -> System.out.println("La cantidad total de jugadores es: " + jugadores.size());
                    case 7 -> mostrarJugadoresPorNacionalidad(
                            jugadores,
                            getString("Ingrese nacionalidad")
                    );
                    case 8 -> System.out.println("Salir del menú");
                    default -> mensajeError("Opción incorrecta, intente nuevamente");
                }
            } while (opcionSeleccionada != 8);

        } catch (InputMismatchException e) {
            mensajeError("Ocurrió un error durante la ejecución del programa");
        } finally {
            System.out.println("Fin del programa");
        }
    }

    public static void altaJugador(ArrayList<Jugador> jugadores) {
        Jugador jugador = new Jugador();
        ingresarDatosJugador(jugador);
        jugadores.add(jugador);
    }

    public static void mostrarDatosJugador(ArrayList<Jugador> jugadores, String nombre, String apellido) {
        if (jugadores.isEmpty()) {
            mensajeListaVacia();
        } else {
            boolean jugadorEncontrado = false;
            for (Jugador jugador : jugadores) {
                if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                    jugador.mostrarInformacion();
                    jugadorEncontrado = true;
                    break;
                }
            }
            if (!jugadorEncontrado) {
                mensajeJugadorNoEncontrado(nombre, apellido);
            }
        }
    }

    public static void mostrarJugadoresOrdenadosPorApellido(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            mensajeListaVacia();
        } else {
            jugadores.sort(Comparator.comparing(Jugador::getApellido));
            for (Jugador jugador : jugadores) {
                jugador.mostrarInformacion();
            }
        }
    }

    public static void modificarDatosJugador(ArrayList<Jugador> jugadores, String nombre, String apellido) {
        if (jugadores.isEmpty()) {
            mensajeListaVacia();
        } else {
            boolean jugadorEncontrado = false;
            for (Jugador jugador : jugadores) {
                if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                    ingresarDatosJugador(jugador);
                    jugadorEncontrado = true;
                    break;
                }
            }
            if (!jugadorEncontrado) {
                mensajeJugadorNoEncontrado(nombre, apellido);
            } else {
                mensajeJugadorModificado(nombre, apellido);
            }
        }
    }

    public static void eliminarJugadorPorNombreCompleto(ArrayList<Jugador> jugadores, String nombre, String apellido) {
        if (jugadores.isEmpty()) {
            mensajeListaVacia();
        } else {
            Iterator<Jugador> iterator = jugadores.iterator();
            Jugador jugador;
            boolean jugadorEncontrado = false;
            while (iterator.hasNext()) {
                jugador = iterator.next();
                if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                    iterator.remove();
                    jugadorEncontrado = true;
                }
            }
            if (!jugadorEncontrado) {
                mensajeJugadorNoEncontrado(nombre, apellido);
            } else {
                mensajeJugadorEliminado(nombre, apellido);
            }
        }
    }

    public static void mostrarJugadoresPorNacionalidad(ArrayList<Jugador> jugadores, final String nacionalidad) {
        if (jugadores.isEmpty()) {
            mensajeListaVacia();
        } else {
            int contador = 0;
            for (Jugador jugador : jugadores) {
                if (jugador.getNacionalidad().equals(nacionalidad)) {
                    contador++;
                }
            }
            mensajeJugadoresPorNacionalidad(nacionalidad, contador);
        }
    }

    public static void ingresarDatosJugador(Jugador jugador) {
        jugador.setNombre(getString("Ingrese nombre"));
        jugador.setApellido(getString("Ingrese apellido"));
        jugador.setFechaNacimiento(obtenerFechaNacimiento());
        jugador.setNacionalidad(getString("Ingrese nacionalidad"));
        jugador.setEstatura(obtenerDouble("Ingrese estatura"));
        jugador.setPeso(obtenerDouble("Ingrese peso"));
        jugador.setPosicion(obtenerPosicion());
    }

    public static String getString(final String mensaje) {
        mensajeInput(mensaje);
        return scanner.nextLine();
    }

    public static String obtenerPosicion() {
        String[] posiciones = {
                "Delantero",
                "Medio",
                "Defensa",
                "Arquero"
        };
        byte posicion;

        while (true) {
            System.out.print("""
                    Submenú: Ingresar posición
                    1 - Delantero
                    2 - Medio
                    3 - Defensa
                    4 - Arquero
                    """);
            posicion = ingresarOpcion();

            if (posicion < 1 || posicion > 4) {
                mensajeError("Seleccione una opción válida");
            } else {
                return posiciones[posicion - 1];
            }
        }
    }

    public static LocalDate obtenerFechaNacimiento() {
        final int dia, mes, anio;

        System.out.println("Ingresar fecha de nacimiento");
        dia = getEntero("Día");
        mes = getEntero("Mes");
        anio = getEntero("Año");

        return LocalDate.of(anio, mes, dia);
    }

    public static int getEntero(final String mensaje) {
        int valorEntero;

        while (true) {
            mensajeInput(mensaje);
            try {
                valorEntero = Integer.parseInt(scanner.nextLine());
                return valorEntero;
            } catch (NumberFormatException e) {
                mensajeError("El valor ingresado debe ser un número entero");
            }
        }
    }

    public static double obtenerDouble(final String mensaje) {
        double valorDouble;

        while (true) {
            mensajeInput(mensaje);
            try {
                valorDouble = Double.parseDouble(scanner.nextLine());
                return valorDouble;
            } catch (NumberFormatException e) {
                mensajeError("El valor ingresado debe ser un número");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.print("""
                Menú:
                1 - Alta del jugador
                2 - Mostrar los datos del jugador
                3 - Mostrar todos los jugadores ordenados por apellido
                4 - Modificar los datos de un jugador
                5 - Eliminar un jugador
                6 - Mostrar la cantidad total de jugadores
                7 - Mostrar la cantidad de jugadores que pertenecen a una nacionalidad
                8 - Salir
                """);
    }

    public static byte ingresarOpcion() {
        byte opcionSeleccionada;

        while (true) {
            try {
                mensajeInput("Seleccione una opción");
                opcionSeleccionada = Byte.parseByte(scanner.nextLine());
                return opcionSeleccionada;
            } catch (NumberFormatException e) {
                mensajeError("Solo se permite el ingreso de números");
            }
        }
    }

    public static void mensajeInput(final String mensaje) {
        System.out.print(mensaje + ": ");
    }

    public static void mensajeError(final String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    public static void mensajeListaVacia() {
        System.out.println("ERROR: La lista de jugadores se encuentra vacía");
    }

    public static void mensajeJugadorEliminado(final String nombre, final String apellido) {
        System.out.printf("Se eliminó al jugador %s %s de la lista de jugadores%n", nombre, apellido);
    }

    public static void mensajeJugadorModificado(final String nombre, final String apellido) {
        System.out.printf("El jugador %s %s ha sido modificado%n", nombre, apellido);
    }

    public static void mensajeJugadorNoEncontrado(final String nombre, final String apellido) {
        System.out.printf("ERROR: El jugador %s %s no se encuentra en la lista de jugadores%n", nombre, apellido);
    }

    public static void mensajeJugadoresPorNacionalidad(final String nacionalidad, final int cantidad) {
        System.out.printf("Cantidad de jugadores %ss: %d%n", nacionalidad, cantidad);
    }
}