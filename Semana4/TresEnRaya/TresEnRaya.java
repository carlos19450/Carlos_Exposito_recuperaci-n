package TresEnRaya;

import java.util.Arrays;
import java.util.Scanner;

public class TresEnRaya {

    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        boolean finJuego = false;


        inicializarTablero(tablero);
        do{
            dibujarTablero(tablero);
            if (comprobarGanador(tablero, 'X')) {
                System.out.println("¡Has ganado!");
                finJuego = true;
            } else if (comprobarGanador(tablero, 'O')){
                System.out.println("¡Has perdido!");
                finJuego = true;
            }else if (!hayMovimientosPosibles(tablero)){
                System.out.println("¡Empate!");
            }else {
                turnoDelJugador(tablero);
                turnoDeLaMaquina(tablero);
            }
        }while (!finJuego);
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j  = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '~';
            }
        }
    }

    public static void dibujarTablero(char[][] tablero) {
        System.out.println("  1 2 3");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean movimientoValido(char[][] tablero, int fila, int columna) {
        if (!hayMovimientosPosibles(tablero)) {
            return false;
        }else {
            if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[fila].length) {
                System.out.println("Error. Ficha fuera del tablero.");
                System.out.println();
                return false;
            } else if (tablero[fila][columna] != '~') {
                System.out.println("Error. La casilla ya está ocupada.");
                System.out.println();
                return false;
            }
        }
        return true;
    }

    public static void turnoDeLaMaquina(char[][] tablero) {
        int fila;
        int columna;
        Jugada jugada;
        System.out.println("Turno de la máquina (O)");
        jugada = buscarMejorJugada(tablero, 'O');
        if (jugada.getTipoDeJugada() == 2) {
            tablero[jugada.getFila()][jugada.getColumna()] = 'O';
        }else {
            jugada = buscarMejorJugada(tablero, 'X');
            if (jugada.getTipoDeJugada() == 2) {
                tablero[jugada.getFila()][jugada.getColumna()] = 'O';
            }else {
                jugada = buscarMejorJugada(tablero, 'O');
                if (jugada.getTipoDeJugada() != 2){
                    if (jugada.getTipoDeJugada() == 2) {
                        tablero[jugada.getFila()][jugada.getColumna()] = 'O';
                    } else if (jugada.getTipoDeJugada() == 1) {
                        tablero[jugada.getFila()][jugada.getColumna()] = 'O';
                    }else {
                        do{
                            fila = (int) (Math.random() * 3);
                            columna = (int) (Math.random() * 3);
                        }while (!movimientoValido(tablero, fila, columna));
                        tablero[fila][columna] = 'O';
                    }
                }
            }
        }
    }

    public static Jugada buscarMejorJugada(char[][] tablero, char tipoDeJugador) {
        Jugada jugada;
        jugada = calcularMejorJugadaDeFilas(tablero, tipoDeJugador);
        if (jugada.getTipoDeJugada() == 2) {
            return jugada;
        }else {
            jugada = calcularMejorJugadaDeColumnas(tablero, tipoDeJugador);
            if (jugada.getTipoDeJugada() == 2) {
                return jugada;
            }else {
                jugada = calcularMejorJugadaDeDiagonalPrincipal(tablero, tipoDeJugador);
                if (jugada.getTipoDeJugada() == 2) {
                    return jugada;
                }else {
                    jugada = calcularMejorJugadaDeDiagonalSecundaria(tablero, tipoDeJugador);
                    if (jugada.getTipoDeJugada() == 2) {
                        return jugada;
                    }else {
                        jugada = calcularMejorJugadaDeFilas(tablero, tipoDeJugador);
                        if (jugada.getTipoDeJugada() == 1) {
                            return jugada;
                        }else {
                            jugada = calcularMejorJugadaDeColumnas(tablero, tipoDeJugador);
                            if (jugada.getTipoDeJugada() == 1) {
                                return jugada;
                            }else {
                                jugada = calcularMejorJugadaDeDiagonalPrincipal(tablero, tipoDeJugador);
                                if (jugada.getTipoDeJugada() == 1) {
                                    return jugada;
                                }else {
                                    jugada = calcularMejorJugadaDeDiagonalSecundaria(tablero, tipoDeJugador);
                                    if (jugada.getTipoDeJugada() == 1) {
                                        return jugada;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return jugada;
    }

    public static Jugada calcularMejorJugadaDeFilas(char[][] tablero, char tipoDeJugador) {
        Jugada jugada = new Jugada();
        int mejorJugada = 0;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas > mejorJugada) {
                mejorJugada = contarFichas;
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[i][j] == '~') {
                        jugada.setTipoDeJugada(mejorJugada);
                        jugada.setFila(i);
                        jugada.setColumna(j);
                    }
                }
            }
            contarFichas = 0;
        }
        return jugada;
    }
    public static Jugada calcularMejorJugadaDeColumnas(char[][] tablero, char tipoDeJugador) {
        Jugada jugada = new Jugada();
        int mejorJugada = 0;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][i] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas > mejorJugada) {
                mejorJugada = contarFichas;
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[j][i] == '~') {
                        jugada.setTipoDeJugada(mejorJugada);
                        jugada.setFila(j);
                        jugada.setColumna(i);
                    }
                }
            }
            contarFichas = 0;
        }
        return jugada;
    }
    public static Jugada calcularMejorJugadaDeDiagonalPrincipal(char[][] tablero, char tipoDeJugador) {
        Jugada jugada = new Jugada();
        int mejorJugada = 0;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == tipoDeJugador) {
                contarFichas++;
            }
            if (contarFichas > mejorJugada) {
                mejorJugada = contarFichas;
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[j][j] == '~') {
                        jugada.setTipoDeJugada(mejorJugada);
                        jugada.setFila(j);
                        jugada.setColumna(j);
                    }
                }
            }
        }
        return jugada;
    }
    public static Jugada calcularMejorJugadaDeDiagonalSecundaria(char[][] tablero, char tipoDeJugador) {
        Jugada jugada = new Jugada();
        int mejorJugada = 0;
        int contarFichas = 0;
        int j = 2;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][j] == tipoDeJugador) {
                contarFichas++;
            }
            j--;
        }
        if (contarFichas > mejorJugada) {
            mejorJugada = contarFichas;
            j = 2;
            for (int i = 0; i < tablero[0].length; i++) {
                if (tablero[i][j] == '~') {
                    jugada.setTipoDeJugada(mejorJugada);
                    jugada.setFila(i);
                    jugada.setColumna(j);
                }
                j--;
            }
        }
        return jugada;
    }

    public static boolean comprobarGanador(char[][] tablero, char ficha) {
        // COMPROBAR FILA
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
                return true;
            }
        }
        // COMPROBAR COLUMNA
        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
                return true;
            }
        }
        // COMPROBAR DIAGONAL PRINCIPAL
        if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
            return true;
        }
        // COMPROBAR DIAGONAL SECUNDARIA
        if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
            return true;
        }
        return false;
    }

    public static boolean hayMovimientosPosibles(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == '~') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void turnoDelJugador(char[][] tablero) {
        Scanner sc = new Scanner(System.in);
        int fila;
        int columna;
        System.out.println("Es tu turno (X)");
        do {
            System.out.print("Fila (1-3): ");
            fila = sc.nextInt() - 1;
            System.out.print("Columna (1-3): ");
            columna = sc.nextInt() - 1;
        } while (!movimientoValido(tablero, fila, columna));
        tablero[fila][columna] = 'X';

    }
}