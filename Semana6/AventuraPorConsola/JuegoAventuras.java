package AventuraPorConsola;

import java.util.Scanner;

public class JuegoAventuras {
    public static void main(String[] args) {
        Enemigo boss = new Enemigo("≠", "Dragon", 1, 50, 5, "¡CUIDADO! ¡Parece un enemigo muy peligroso!");
        Personaje jugador = new Personaje(3, 2, "Jugador", 1, 100, 0, 10);
        Zona[][] tablero = new Zona[4][5];
        inicializarTablero(tablero, boss, jugador);
        System.out.println("¡Bienvenido al juego de aventuras!\n" +
                "¡Encuentra y mata al BOSS final para salvar al mundo!");
        do {
            turnoDelJugador(tablero, jugador);
        }while (boss.getSalud() > 0);

    }

    public static void inicializarTablero(Zona[][] tablero, Enemigo boss, Personaje jugador) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = new Zona(null, null, null);
            }
        }
        meterObjetosEnTablero(tablero, boss, jugador);
    }

    public static void meterObjetosEnTablero(Zona[][] tablero, Enemigo boss, Personaje jugador) {
        Equipo arma = new Arma("!", "Espada", 15, "una espada afilada con una grand piedra roja y brillante.");
        Equipo escudo = new Escudo("O", "Escudo", 10, "un escudo blindado de platino.");
        tablero[0][2] = new Zona(null, boss, null);
        tablero[3][2] = new Zona(jugador, null, null);
        tablero[2][1] = new Zona(null, null, arma);
        tablero[3][4] = new Zona(null, null, escudo);
    }

    public static void turnoDelJugador(Zona[][] tablero, Personaje jugador) {
        Scanner sc = new Scanner(System.in);
        boolean movimientoValido = false;
        String[] arrayDeRespuestas;
        int[] coordenadaXYanteriores = new int[2];
        Zona zona = new Zona();
        String accion;
        do {
            dibujarTablero(tablero);
            System.out.print("> ");
            accion = sc.nextLine();
            arrayDeRespuestas = accion.split(" ");
            if (arrayDeRespuestas[0].equalsIgnoreCase("mover")) {
                if (validarAccion(arrayDeRespuestas)) {
                    zona = calcularCoordenadasAnteriores(tablero, coordenadaXYanteriores, zona);
                    if (calcularSiElMovimientoEsValido(jugador.getPosicionX(), jugador.getPosicionY(), arrayDeRespuestas[1])) {
                        movimientoValido = moverse(arrayDeRespuestas, jugador);
                        if (tablero[jugador.getPosicionX()][jugador.getPosicionY()].hayObjeto()) {
                            System.out.println("¿Quieres explorar?");
                            accion = sc.nextLine();
                            if (accion.equalsIgnoreCase("si")) {
                                explorar(tablero, jugador);
                                System.out.println("¿Lo quieres equipar?");
                                accion = sc.nextLine();
                                if (accion.equalsIgnoreCase("si")) {
                                    equipar(tablero, jugador, coordenadaXYanteriores);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
        } while (!movimientoValido);
        // BORRO EL OBJETO DE LA CLASE ZONA ANTERIOR POR UNO NUEVO (VACIO)
        tablero[coordenadaXYanteriores[0]][coordenadaXYanteriores[1]] = new Zona();
        // PASO LA ZONA ANTERIOR QUE TENIA MI PERSONAJE A LA NUEVA ZONA
        tablero[jugador.getPosicionX()][jugador.getPosicionY()] = zona;
        System.out.println(jugador);
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

    public static boolean validarAccion(String[] arrayDeRespuestas) {
        boolean moverse = false;
        if (arrayDeRespuestas[0].equalsIgnoreCase("mover") && arrayDeRespuestas[1].equalsIgnoreCase("norte")) {
            moverse = true;
        } else if (arrayDeRespuestas[0].equalsIgnoreCase("mover") && arrayDeRespuestas[1].equalsIgnoreCase("este")) {
            moverse = true;
        } else if (arrayDeRespuestas[0].equalsIgnoreCase("mover") && arrayDeRespuestas[1].equalsIgnoreCase("sur")) {
            moverse = true;
        } else if (arrayDeRespuestas[0].equalsIgnoreCase("mover") && arrayDeRespuestas[1].equalsIgnoreCase("oeste")) {
            moverse = true;
        }
        return moverse;
    }

    public static Zona calcularCoordenadasAnteriores(Zona[][] tablero, int[] coordenadaXYanteriores, Zona zona) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].toString().equalsIgnoreCase("1")) {
                    coordenadaXYanteriores[0] = i;
                    coordenadaXYanteriores[1] = j;
                    zona = tablero[i][j];
                }
            }
        }
        return zona;
    }

    public static boolean calcularSiElMovimientoEsValido(int fila, int columna, String arrayDeRespuesta) {
        if (arrayDeRespuesta.equalsIgnoreCase("norte")) {
            fila--;
        } else if (arrayDeRespuesta.equalsIgnoreCase("este")) {
            columna++;
        } else if (arrayDeRespuesta.equalsIgnoreCase("sur")) {
            fila++;
        } else if (arrayDeRespuesta.equalsIgnoreCase("oeste")) {
            columna--;
        }else {
            return false;
        }
        return movimientoValido(fila, columna);
    }

    public static boolean movimientoValido(int fila, int columna) {
        return fila >= 0 && fila <= 3 && columna >= 0 && columna <= 4;
    }

    public static boolean moverse(String[] arrayDeRespuestas, Personaje jugador) {
        Moverse moverse = new Moverse(arrayDeRespuestas[1]);
        //
        jugador.moverse(moverse);
        return true;
    }

    public static void explorar(Zona[][] tablero, Personaje jugador) {
        Habilidad explorar = new Explorar(tablero);
        jugador.explorar(explorar);
    }

    public static void equipar(Zona[][] tablero, Personaje jugador, int[] coordenadaXYanteriores) {
        Equipo objeto = tablero[jugador.getPosicionX()][jugador.getPosicionY()].getEquipo();
        jugador.agregarObjeto(objeto);
        tablero[jugador.getPosicionX()][jugador.getPosicionY()].setEquipo(null);
        if (coordenadaXYanteriores[0] != jugador.getPosicionX() || coordenadaXYanteriores[1] != jugador.getPosicionY()) {
            tablero[coordenadaXYanteriores[0]][coordenadaXYanteriores[1]].setEquipo(objeto);
        }
    }
}