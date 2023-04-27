package EjerciciosBasicosPOO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    public Persona(String dni, String nombre, String apellidos, int edad) {
        if (!validarDNI(dni)) {
            System.out.println("Error. Dni falso");
        }else {
            this.dni = dni;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.edad = edad;
        }

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void imprime() {
        System.out.println(dni +" "+ nombre + " "+ apellidos +" "+ edad);
    }
    public boolean esMayorEdad() {
        return edad >=18;
    }

    public boolean esJubilado() {
        return edad >=65;
    }

    public int diferenciaEdad(Persona p) {
        return Math.abs(this.edad - p.edad);
    }

    public static boolean validarDNI(String dni){
        Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Matcher mat = pat.matcher(dni);
        return mat.matches();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }
}
