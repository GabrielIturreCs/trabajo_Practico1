package ar.edu.unju.fi.ejercicio12.model;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Persona {
private String Nombre;
private Calendar FechaNacimiento;

public Persona(String nombre, Calendar fechaNacimiento) {
    this.Nombre = nombre;
    this.FechaNacimiento = fechaNacimiento;
}
public int obtenerEdad() {
    Calendar ahora = Calendar.getInstance();
    int edad = ahora.get(Calendar.YEAR) - FechaNacimiento.get(Calendar.YEAR);
    if (ahora.get(Calendar.DAY_OF_YEAR) < FechaNacimiento.get(Calendar.DAY_OF_YEAR)) {
        edad--; 
    }
    return edad;
}


public String obtenerSignoZodiacal() {
    int mes = FechaNacimiento.get(Calendar.MONTH) + 1; // le  sumo 1 porque los meses en Calendar van de 0 a 11
    int dia = FechaNacimiento.get(Calendar.DAY_OF_MONTH);

    switch (mes) {
    case 1: // Enero
        if (dia <= 20)
            return "Capricornio";
        else
            return "Acuario";
    case 2: // Febrero
        if (dia <= 19)
            return "Acuario";
        else
            return "Piscis";
    case 3: // Marzo
        if (dia <= 20)
            return "Piscis";
        else
            return "Aries";
    case 4: // Abril
        if (dia <= 20)
            return "Aries";
        else
            return "Tauro";
    case 5: // Mayo
        if (dia <= 21)
            return "Tauro";
        else
            return "Géminis";
    case 6: // Junio
        if (dia <= 21)
            return "Géminis";
        else
            return "Cáncer";
    case 7: // Julio
        if (dia <= 22)
            return "Cáncer";
        else
            return "Leo";
    case 8: // Agosto
        if (dia <= 23)
            return "Leo";
        else
            return "Virgo";
    case 9: // Septiembre
        if (dia <= 23)
            return "Virgo";
        else
            return "Libra";
    case 10: // Octubre
        if (dia <= 23)
            return "Libra";
        else
            return "Escorpio";
    case 11: // Noviembre
        if (dia <= 22)
            return "Escorpio";
        else
            return "Sagitario";
    case 12: // Diciembre
        if (dia <= 21)
            return "Sagitario";
        else
            return "Capricornio";
    default:
        return "Signo no definido";
}
}
public String obtenerEstacion() {
    int mes = FechaNacimiento.get(Calendar.MONTH) + 1; // le acabo de sumar 1 porque los meses van de 0 a 11
    switch (mes) {
        case 1:
        case 2:
            return "Verano"; // Enero y febrero
        case 3:
            if (FechaNacimiento.get(Calendar.DAY_OF_MONTH) < 21) {
                return "Verano"; // Hasta el 20 de marzo es verano
            } else {
                return "Otoño"; // A partir del 21 de marzo es otoño
            }
        case 4:
        case 5:
            return "Otoño"; // Abril y mayo
        case 6:
            if (FechaNacimiento.get(Calendar.DAY_OF_MONTH) < 21) {
                return "Otoño"; // Hasta el 20 de junio es otoño
            } else {
                return "Invierno"; // A partir del 21 de junio es invierno
            }
        case 7:
        case 8:
            return "Invierno"; // Julio y agosto
        case 9:
            if (FechaNacimiento.get(Calendar.DAY_OF_MONTH) < 21) {
                return "Invierno"; // Hasta el 20 de septiembre es invierno
            } else {
                return "Primavera"; // A partir del 21 de septiembre es primavera
            }
        case 10:
        case 11:
            return "Primavera"; // Octubre y noviembre
        case 12:
            if (FechaNacimiento.get(Calendar.DAY_OF_MONTH) < 21) {
                return "Primavera"; // Hasta el 20 de diciembre es primavera
            } else {
                return "Verano"; // A partir del 21 de diciembre es verano
            }
        default:
            return "Estación no definida";
    }
}


public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return "Persona [Nombre=" + Nombre + ", FechaNacimiento=" + dateFormat.format(FechaNacimiento.getTime()) +
           ", Edad=" + obtenerEdad() + ", SignoZodiacal=" + obtenerSignoZodiacal() + ", Estación=" + obtenerEstacion() + "]";
}
}




	


