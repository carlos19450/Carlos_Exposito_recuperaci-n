package AventuraPorConsola;

import java.util.Scanner;

public class JuegoAventuras {
    public static void main(String[] args) {
        Enemigo boss = new Enemigo("≠", "Dragon", 1, 50, 5);
        Personaje jugador = new Personaje("Jugador", 1, 100, 0, 10);
        Zona[][] tablero = new Zona[4][5];
        inicializarTablero(tablero, boss, jugador);
        System.out.println("¡Bienvenido al juego de aventuras!\n" +
                "¡Encuentra y mata al BOSS final y salva al mundo!");
        do {
            /*
            // Crear objetos y enemigos
            Equipo arma = new Arma("Espada", 15);
            Equipo escudo = new Escudo("Escudo", 10);
            //Objeto armadura = new Armadura("Escudo", 10);
            // Añadir objetos al equipo del jugador
            jugador.agregarObjeto(arma);
            jugador.agregarObjeto(escudo);
            //jugador.agregarObjeto(armadura);
            // Mostrar información del jugador
            System.out.println(jugador);
            System.out.println();
            // Quitar un objeto del equipo del personaje
            jugador.quitarObjeto(arma);
            jugador.quitarObjeto(escudo);
            // Mostrar detalles del personaje después de quitar un objeto
            System.out.println(jugador);
            System.out.println();
            // Atacar al enemigo
            jugador.atacar(boss);
            //Mostrar detalles del enemigo
            System.out.println(boss);*/
            dibujarTablero(tablero);
            turnoDelJugador(tablero, jugador);
        }while (boss.getSalud() > 0);

    }

    public static void inicializarTablero(Zona[][] tablero, Enemigo boss, Personaje jugador) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                    tablero[i][j] = new Zona(i, j, null, null);
            }
        }
        tablero[0][2] = new Zona(0, 2, null, boss);
        tablero[3][2] = new Zona(3, 2, jugador, null);
        jugador.setPosicionX(3);
        jugador.setPosicionY(2);
    }

    public static void dibujarTablero(Zona[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean movimientoValido(Zona[][] tablero, int fila, int columna) {
        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[fila].length) {
            System.out.println("Error. Ficha fuera del tablero.");
            System.out.println();
            return false;
        }
        return true;
    }

    public static void turnoDelJugador(Zona[][] tablero, Personaje jugador) {
        String[] arrayDeRespuestas;
        int x = 0;
        int y = 0;
        Zona zona = new Zona();
        String accion;
        Scanner sc = new Scanner(System.in);
        int fila = 0;
        int columna = 0;
        do {
            System.out.print("> ");
            accion = sc.nextLine();
            arrayDeRespuestas = accion.split(" ");
            if (validarAccion(arrayDeRespuestas)) {
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        if (tablero[i][j].toString().equals("1")) {
                            x = i;
                            y = j;
                            zona = tablero[i][j];
                        }
                    }
                }
                Habilidad moverse = new Moverse(arrayDeRespuestas[1]);
                jugador.moverse(moverse);
                tablero[jugador.getPosicionX()][jugador.getPosicionY()] = zona;
                tablero[x][y] = new Zona();
            }
            System.out.println();
        } while (!movimientoValido(tablero, fila, columna));
    }

    public static boolean validarAccion(String[] arrayDeRespuestas) {
        boolean moverse = false;
            if (arrayDeRespuestas[0].equals("mover") && arrayDeRespuestas[1].equals("norte")) {
                moverse = true;
            } else if (arrayDeRespuestas[0].equals("mover") && arrayDeRespuestas[1].equals("este")) {
                moverse = true;
            } else if (arrayDeRespuestas[0].equals("mover") && arrayDeRespuestas[1].equals("sur")) {
                moverse = true;
            } else if (arrayDeRespuestas[0].equals("mover") && arrayDeRespuestas[1].equals("oeste")) {
                moverse = true;
            }
        return moverse;
    }
}
