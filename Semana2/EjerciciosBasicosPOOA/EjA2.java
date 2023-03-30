package EjerciciosBasicosPOOA;

import EjerciciosBasicosPOO.Persona;

import java.util.Scanner;

public class EjA2 {
    public static void main(String[] args) {
        Persona persona1;
        Persona persona2;
        Scanner sc = new Scanner(System.in);
        String dni;
        String nombre;
        String apellidos;
        int edad;
        String esMayorDeEdad = null;

        System.out.println("Dni:");
        dni = sc.next();
        System.out.println("Nombre:");
        nombre = sc.next();
        System.out.println("Apellidos:");
        apellidos = sc.next();
        System.out.println("Edad:");
        edad = sc.nextInt();
        System.out.println();
        persona1 = new Persona(dni, nombre, apellidos, edad);

        System.out.println("Dni:");
        dni = sc.next();
        System.out.println("Nombre:");
        nombre = sc.next();
        System.out.println("Apellidos:");
        apellidos = sc.next();
        System.out.println("Edad:");
        edad = sc.nextInt();
        System.out.println();
        persona2 = new Persona(dni, nombre, apellidos, edad);

        if (persona1.getEdad() >= 18) {
            esMayorDeEdad = " es mayor de edad";
        }else{
            esMayorDeEdad = " no es mayor de edad";
        }

        System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " con DNI " + persona1.getDni() + esMayorDeEdad);
        if (persona2.getEdad() >= 18) {
            esMayorDeEdad = " es mayor de edad";
        }else{
            esMayorDeEdad = " no es mayor de edad";
        }
        System.out.println(persona2.getNombre() + " " + persona2.getApellidos() + " con DNI " + persona2.getDni() + esMayorDeEdad);

    }
}
