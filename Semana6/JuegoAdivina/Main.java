package JuegoAdivina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Adivina juego;
        System.out.print("""
                ¡Bienvenido a ¡Adivina!\s
                Selecciona el modo de juego:
                1. Modo Animales
                2. Modo Frutas
                3. Modo Famosos
                4. Modo Videojuegos
                Introducir:\s""");
        System.out.print("");
        juego = elegirModoDeJuego();
        juego.generarObjetoSecreto();
        System.out.println("Puntos: 100");
        jugar(juego);
    }
    public static Adivina elegirModoDeJuego() {
        Adivina juego;
        Scanner scanner = new Scanner(System.in);
        int modoDeJuego;
        modoDeJuego = scanner.nextInt();
        switch (modoDeJuego) {
            case 1 -> juego = new AdivinaAnimales();
            case 2 -> juego = new AdivinaFrutas();
            case 3 -> juego = new AdivinaFamosos();
            case 4 -> juego = new AdivinaVideojuegos();
            default -> {
                System.out.println("Opción no válida. Seleccionando modo Animales por defecto.");
                juego = new AdivinaAnimales();
            }
        }
        System.out.println();
        return juego;
    }

    public static void jugar(Adivina juego) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayDeRespuestas;
        boolean jugar;
        boolean adivinado = false;
        String respuesta;
        do {
            jugar = true;
            System.out.print("""
                    Intenta adivinar el objeto\s
                    Puedes pedir una pista introduciendo la palabra 'pista'
                    Introducir:\s""");
            respuesta = scanner.nextLine();
            System.out.println();
            arrayDeRespuestas = respuesta.split(" ");
            for (int i = 0; i < arrayDeRespuestas.length; i++) {
                if (arrayDeRespuestas[i].equalsIgnoreCase("pista")) {
                    juego.mostrarPista();
                    jugar = false;
                }
            }
            if (jugar) {
                adivinado = juego.adivinarObjetoSecreto(respuesta);
            }
            System.out.println("Puntos: " + juego.getPuntos());
            if (juego.getPuntos() <= 0) {
                adivinado = true;
            }
        } while (!adivinado);
    }
}