package JuegoAdivina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String respuesta;
        System.out.println("¡Bienvenido a ¡Adivina!");
        System.out.println("Selecciona el modo de juego:");
        System.out.println("1. Modo Animales");
        System.out.println("2. Modo Frutas");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        Adivina juego;
        switch (opcion) {
            case 1:
                juego = new AdivinaAnimales();
                break;
            case 2:
                juego = new AdivinaFrutas();
                break;
            default:
                System.out.println("Opción no válida. Seleccionando modo Animales por defecto.");
                        juego = new AdivinaAnimales();
                break;
        }
        juego.generarObjetoSecreto();
        juego.mostrarPista();
        System.out.print("Intenta adivinar el objeto: ");
        respuesta = scanner.next();
        juego.adivinarObjetoSecreto(respuesta);
    }
}

