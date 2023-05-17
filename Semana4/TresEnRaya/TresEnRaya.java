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
                dibujarTablero(tablero);
                System.out.println("¡Has ganado!");
                finJuego = true;
            } else if (comprobarGanador(tablero, 'O')){
                dibujarTablero(tablero);
                System.out.println("¡Has perdido!");
                finJuego = true;
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

    public static boolean turno(char[][] tablero) {
        // ATACAR = TRUE || DEFENDER = FALSE
        boolean atacarOdefender = false;
        int tipoDeJugada;
        tipoDeJugada = buscarMejorJugadaParaLaMaquina(tablero, 'X'); // devolver clase jugada: nivel. i,j
        //System.out.println("aaaa: " + tipoDeJugada);
        if (tipoDeJugada == 2) {
            //tablero[jugada.i, jugada.j] = 'O';
            atacarOdefender = buscarMejorJugadaParaAtacar(tablero, 'X');
        }else if (tipoDeJugada == 1){
            //buscarMejorJugada(tablero, '0');
            //tablero[jugado.i, jugado.j] = '0';
            atacarOdefender = buscarMejorJugadaParaDefender(tablero, 'O');
        }
        return atacarOdefender;
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

    public static boolean buscarMejorJugadaParaAtacar(char[][] tablero, char tipoDeJugador) { // parametro char jugador, devuelva -1, 0, 1, 2
        boolean comprobarYcolocarFicha;
        // COMPROBAR LAS X DE LAS FILA
        comprobarYcolocarFicha = comprobarYcolocarFilasDe2(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
            return comprobarYcolocarFicha;
        }
        // COMPROBAR LAS X DE LAS COLUMNAS
        comprobarYcolocarFicha = comprobarYcolocarColumnasDe2(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
            return comprobarYcolocarFicha;
        }
        // COMPROBAR LAS X DE LA DIAGONAL PRINCIPAL
        comprobarYcolocarFicha = comprobarYcolocarDiagonalPrincipalDe2(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
            return comprobarYcolocarFicha;
        }
        // COMPROBAR LAS X DE LA DIAGONAL SECUNDARIA
        comprobarYcolocarFicha = comprobarYcolocarDiagonalSecundariaDe2(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
            return comprobarYcolocarFicha;
        }
        return comprobarYcolocarFicha;
    }
    public static boolean comprobarYcolocarFilasDe2(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 2) {
                for (int k = 0; k < tablero[0].length; k++) {
                    if (tablero[i][k] == '~') {
                        tablero[i][k] = 'O';
                        colocarFicha = true;
                    }
                }

            }
            contarFichas = 0;
        }
        return colocarFicha;
    }
    public static boolean comprobarYcolocarColumnasDe2(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][i] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 2) {
                for (int k = 0; k < tablero[0].length; k++) {
                    if (tablero[k][i] == '~') {
                        tablero[k][i] = 'O';
                        colocarFicha = true;
                    }
                }
            }
            contarFichas = 0;
        }
        return colocarFicha;
    }
    public static boolean comprobarYcolocarDiagonalPrincipalDe2(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == tipoDeJugador) {
                contarFichas++;
            }
        }
        if (contarFichas == 2) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][j] == '~') {
                    tablero[j][j] = 'O';
                    colocarFicha = true;
                }
            }
        }
        return colocarFicha;
    }
    public static boolean comprobarYcolocarDiagonalSecundariaDe2(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        int j = 2;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][j] == tipoDeJugador) {
                contarFichas++;
            }
            j--;
        }
        if (contarFichas == 2) {
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

    public static boolean buscarMejorJugadaParaDefender(char[][] tablero, char tipoDeJugador) { // parametro char jugador, devuelva -1, 0, 1, 2
        boolean comprobarYcolocarFicha;
        comprobarYcolocarFicha = comprobarYcolocarFilasDe1(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
                return true;
            }
        comprobarYcolocarFicha = comprobarYcolocarColumnasDe1(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
                return true;
            }
        comprobarYcolocarFicha = comprobarYcolocarDiagonalPrincipalDe1(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
                return true;
            }
        comprobarYcolocarFicha = comprobarYcolocarDiagonalSecundariaDe1(tablero, tipoDeJugador);
        if (comprobarYcolocarFicha) {
                return true;
            }
        return false;
    }

    public static boolean comprobarYcolocarFilasDe1(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 1) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[i][j] == '~') {
                        tablero[i][j] = 'O';
                        colocarFicha = true;
                    }
                }

            }
            contarFichas = 0;
        }
        return colocarFicha;
    }
    public static boolean comprobarYcolocarColumnasDe1(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][i] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 1) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[j][i] == '~') {
                        tablero[j][i] = 'O';
                        colocarFicha = true;
                    }
                }
            }
            contarFichas = 0;
        }
        return colocarFicha;
    }
    public static boolean comprobarYcolocarDiagonalPrincipalDe1(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == tipoDeJugador) {
                contarFichas++;
            }
        }
        if (contarFichas == 1) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][j] == '~') {
                    tablero[j][j] = 'O';
                    colocarFicha = true;
                }
            }
        }
        return colocarFicha;
    }
    public static boolean comprobarYcolocarDiagonalSecundariaDe1(char[][] tablero, char tipoDeJugador) {
        boolean colocarFicha = false;
        int contarFichas = 0;
        int j = 2;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][j] == tipoDeJugador) {
                contarFichas++;
            }
            j--;
        }
        if (contarFichas == 1) {
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

    public static int buscarMejorJugadaParaLaMaquina(char[][] tablero, char tipoDeJugador) { // parametro char jugador, devuelva -1, 0, 1, 2
        int mejorJugada;
        // COMPROBAR SI HAY 2 X
        mejorJugada = comprobarFilas2(tablero, tipoDeJugador);
        if (mejorJugada == 2) {
            return mejorJugada;
        }
        mejorJugada = comprobarColumnas2(tablero, tipoDeJugador);
        if (mejorJugada == 2) {
            return mejorJugada;
        }
        mejorJugada = comprobarDiagonalPrincipal2(tablero, tipoDeJugador);
        if (mejorJugada == 2) {
            return mejorJugada;
        }
        mejorJugada = comprobarDiagonalSecundaria2(tablero, tipoDeJugador);
        if (mejorJugada == 2) {
            return mejorJugada;
        }
        // COMPROBAR SI HAY 1 X
        mejorJugada = comprobarFilas1(tablero, tipoDeJugador);
        if (mejorJugada == 1) {
            return mejorJugada;
        }
        mejorJugada = comprobarColumnas1(tablero, tipoDeJugador);
        if (mejorJugada == 1) {
            return mejorJugada;
        }
        mejorJugada = comprobarDiagonalPrincipal1(tablero, tipoDeJugador);
        if (mejorJugada == 1) {
            return mejorJugada;
        }
        mejorJugada = comprobarDiagonalSecundaria1(tablero, tipoDeJugador);
        if (mejorJugada == 1) {
            return mejorJugada;
        }
        return 0;
    }

    public static int comprobarFilas2(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 2) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[i][j] == '~') {
                        return 2;
                    }
                }
            }
            contarFichas = 0;
        }
        return 0;
    }
    public static int comprobarColumnas2(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][i] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 2) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[j][i] == '~') {
                        return 2;
                    }
                }
            }
            contarFichas = 0;
        }
        return 0;
    }
    public static int comprobarDiagonalPrincipal2(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == tipoDeJugador) {
                contarFichas++;
            }
        }
        if (contarFichas == 2) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][j] == '~') {
                    return 2;
                }
            }
        }
        return 0;
    }
    public static int comprobarDiagonalSecundaria2(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        int j = 2;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][j] == tipoDeJugador) {
                contarFichas++;
            }
            j--;
        }
        if (contarFichas == 2) {
            j = 2;
            for (int i = 0; i < tablero[0].length; i++) {
                if (tablero[i][j] == '~') {
                    return 2;
                }
                j--;
            }
        }
        return 0;
    }

    public static int comprobarFilas1(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 1) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[i][j] == '~') {
                        return 1;
                    }
                }
            }
            contarFichas = 0;
        }
        return 0;
    }
    public static int comprobarColumnas1(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][i] == tipoDeJugador) {
                    contarFichas++;
                }
            }
            if (contarFichas == 1) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[j][i] == '~') {
                        return 1;
                    }
                }
            }
            contarFichas = 0;
        }
        return 0;
    }
    public static int comprobarDiagonalPrincipal1(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == tipoDeJugador) {
                contarFichas++;
            }
        }
        if (contarFichas == 1) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[j][j] == '~') {
                    return 1;
                }
            }
        }
        return 0;
    }
    public static int comprobarDiagonalSecundaria1(char[][] tablero, char tipoDeJugador) {
        int contarFichas = 0;
        int j = 2;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][j] == tipoDeJugador) {
                contarFichas++;
            }
            j--;
        }
        if (contarFichas == 1) {
            j = 2;
            for (int i = 0; i < tablero[0].length; i++) {
                if (tablero[i][j] == '~') {
                    return 1;
                }
                j--;
            }
        }
        return 0;
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

    public static void turnoDeLaMaquina(char[][] tablero) {
        int fila;
        int columna;
        System.out.println("Turno de la máquina (O)");
        if (!turno(tablero)) {
            do {
                fila = (int) (Math.random() * 3);
                columna = (int) (Math.random() * 3);
            }while (!movimientoValido(tablero, fila, columna));
            if (movimientoValido(tablero, fila, columna)) {
                tablero[fila][columna] = 'O';
            }
        }
    }
}