package EjerciciosBasicosPOOE;

import EjerciciosBasicosPOO.Persona;

import java.util.Scanner;

public class EjE2 {
    public static void main(String[] args) {
        Persona persona1;
        Persona persona2;
        Scanner sc = new Scanner(System.in);
        String dni;
        String nombre;
        String apellidos;
        int edad;
        String esMayorDeEdad;
        String esJubilado;

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

        persona1.imprime();
        persona2.imprime();
        System.out.println();

        if (persona1.esMayorEdad()) {
            esMayorDeEdad = " es mayor de edad";
        }else{
            esMayorDeEdad = " no es mayor de edad";
        }

        if (persona1.esJubilado()) {
            esJubilado = "esta jubilado";
        }else{
            esJubilado = "no esta jubilado";
        }

        System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " con DNI " + persona1.getDni() + esMayorDeEdad + " " + esJubilado);

        System.out.println();

        if (persona2.esMayorEdad()) {
            esMayorDeEdad = " es mayor de edad";
        }else{
            esMayorDeEdad = " no esta mayor de edad";
        }

        if (persona2.esJubilado()) {
            esJubilado = " es jubilado";
        }else{
            esJubilado = " no esta jubilado";
        }
        System.out.println(persona2.getNombre() + " " + persona2.getApellidos() + " con DNI " + persona2.getDni() + esMayorDeEdad + " " + esJubilado);

        System.out.println("La diferecia de edad es de: " + persona1.diferenciaEdad(persona2) + " años");
    }
}
