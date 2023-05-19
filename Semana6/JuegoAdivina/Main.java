package JuegoAdivina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Adivina juego;
        Scanner scanner = new Scanner(System.in);
        String[] arrayDeRespuestas;
        int modoDeJuego;
        String respuesta;
        System.out.print("""
                ¡Bienvenido a ¡Adivina!\s
                Selecciona el modo de juego:
                1. Modo Animales
                2. Modo Frutas
                Introducir:\s""");
        System.out.print("");
        modoDeJuego = scanner.nextInt();
        System.out.println();
        switch (modoDeJuego) {
            case 1 -> juego = new AdivinaAnimales();
            case 2 -> juego = new AdivinaFrutas();
            default -> {
                System.out.println("Opción no válida. Seleccionando modo Animales por defecto.");
                juego = new AdivinaAnimales();
            }
        }
        juego.generarObjetoSecreto();
        System.out.println("Puntos: 100");
        do {
            System.out.print("""
                    Intenta adivinar el objeto\s
                    Puedes pedir una pista introduciendo la palabra 'pista'
                    Introducir:\s""");
            respuesta = scanner.next();
            System.out.println();
            arrayDeRespuestas = respuesta.split(" ");
            do {
                for (String arrayDeRespuesta : arrayDeRespuestas) {
                    System.out.println(arrayDeRespuesta);
                    //if (arrayDeRespuesta.equalsIgnoreCase("pista")) {
                    //    juego.mostrarPista();
                    //}
                }
            }while ();
            juego.adivinarObjetoSecreto(respuesta);
            System.out.println("Puntos: " + juego.getPuntos());
        }while (juego.getPuntos() != 0);
    }
}

