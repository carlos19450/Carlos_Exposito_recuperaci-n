package TresEnRaya;

import java.util.Arrays;
import java.util.Scanner;

public class TresEnRaya {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        Scanner sc = new Scanner(System.in);
        boolean finJuego = false;
        int fila;
        int columna;

        inicializarTablero(tablero);
        do{
            dibujarTablero(tablero);
            if (comprobarGanador(tablero, 'X')) {
                dibujarTablero(tablero);
                System.out.println("¡Has ganado!");
                finJuego = true;
            } else if (comprobarGanador(tablero, '0')){
                dibujarTablero(tablero);
                System.out.println("¡Has perdido!");
                finJuego = true;
            }else {
                System.out.println("Es tu turno (X)");
                do {
                    System.out.print("Fila (1-3): ");
                    fila = sc.nextInt() - 1;
                    System.out.print("Columna (1-3): ");
                    columna = sc.nextInt() - 1;
                } while (!movimientoValido(tablero, fila, columna));
                tablero[fila][columna] = 'X';
                System.out.println("Turno de la máquina (O)");
                if (!turnoDeLaMaquina(tablero)) {
                    do {
                        fila = (int) (Math.random() * 3);
                        columna = (int) (Math.random() * 3);
                    }while (!movimientoValido(tablero, fila, columna));
                    if (movimientoValido(tablero, fila, columna)) {
                        tablero[fila][columna] = 'O';
                    }
                }
            }
            if (!hayMovimientosPosibles(tablero)) {
                dibujarTablero(tablero);
                System.out.println("¡Empate!");
                finJuego = true;
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
        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[fila].length) {
            System.out.println("Error. Ficha fuera del tablero.");
            System.out.println();
            return false;
        } else if (tablero[fila][columna] != '~') {
            System.out.println("Error. La casilla ya está ocupada.");
            System.out.println();
            return false;
        } else {
            return true;
        }
    }

    public static void turno() {
        // si vaAGanar() // tiene dentro comprobarfilas/comprobarcolumnas/ y coloca la ficha muy parecido a turnodelamaquina
        //if turnoDeLaMaquina(jugador)== 2 { // le cambias el nombre a la funcion buscarmejorjugada()
            // jugada para defender;

        // si no vaAGanar()
        //} else {
            //      buscoMejorJugada(bot) // -1 si esa fila / columna no se pueda completar 0 si esta vacia, 1 si ya hay una ficha mia, 2 si hay 2
            // jugada {-1/0/1/2, i, j}
            //jugar(1,2)
        //}
    }
    public static boolean turnoDeLaMaquina(char[][] tablero) { // parametro char jugador, devuelva -1, 0, 1, 2
        boolean colocarFicha;
                // COMPROBAR LAS X DE LAS FILA
                colocarFicha = comprobarFilas(tablero); //colocar ficha si el otro va a ganar

        //

                if (colocarFicha) {
                    return colocarFicha;
                }
                // COMPROBAR LAS X DE LAS COLUMNAS
                colocarFicha = comprobarColumnas(tablero);
                if (colocarFicha) {
                    return colocarFicha;
                }
                // COMPROBAR LAS X DE LA DIAGONAL PRINCIPAL
                colocarFicha = comprobarDiagonalPrincipal(tablero);
                if (colocarFicha) {
                    return colocarFicha;
                }
                // COMPROBAR LAS X DE LA DIAGONAL SECUNDARIA
                colocarFicha = comprobarDiagonalSecundaria(tablero);
                if (colocarFicha) {
                    return colocarFicha;
                }
        return colocarFicha;
    }
    public static boolean comprobarFilas(char[][] tablero) {
        boolean colocarFicha = false;
        int cont = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == 'X') {
                    cont++;
                }
            }
            if (cont == 2) {
                //MIRO DONDE ESTAN LAS 'X'
                for (int k = 0; k < tablero[0].length; k++) {
                    if (tablero[i][k] == '~') {
                        tablero[i][k] = 'O';
                        colocarFicha = true;
                    }
                }
            }
            cont = 0;
        }
        return colocarFicha;
    }
    public static boolean comprobarColumnas(char[][] tablero) {
        boolean colocarFicha = false;
        int cont = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][i] == 'X') {
                    cont++;
                }
            }
            if (cont == 2) {
                //MIRO DONDE ESTAN LAS 'X'
                for (int k = 0; k < tablero[0].length; k++) {
                    if (tablero[k][i] == '~') {
                        tablero[k][i] = 'O';
                        colocarFicha = true;
                    }
                }
            }
            cont = 0;
        }
        return colocarFicha;
    }
    public static boolean comprobarDiagonalPrincipal(char[][] tablero) {
        boolean colocarFicha = false;
        int cont = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == 'X') {
                cont++;
            }
        }
        if (cont == 2) {
            //MIRO DONDE ESTAN LAS 'X'
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][j] == '~') {
                    tablero[j][j] = 'O';
                    colocarFicha = true;
                }
            }
        }
        return colocarFicha;
    }
    public static boolean comprobarDiagonalSecundaria(char[][] tablero) {
        boolean colocarFicha = false;
        int cont = 0;
        int j = 2;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][j] == 'X') {
                cont++;
            }
            j--;
        }
        if (cont == 2) {
            //MIRO DONDE ESTAN LAS 'X'
            j = 2;
            for (int i = 0; i < tablero[0].length; i++) {
                if (tablero[i][j] == '~') {
                    tablero[i][j] = 'O';
                    colocarFicha = true;
                }
                j--;
            }
        }

        return colocarFicha;
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
}