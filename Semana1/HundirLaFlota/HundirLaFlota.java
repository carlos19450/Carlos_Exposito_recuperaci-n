package HundirLaFlota;

import java.sql.SQLOutput;

public class HundirLaFlota {
    public static String [][] tablero = new String[9][9];
    public static void main(String[] args) {
        crearTablero();

    }
    public static void crearTablero() {
        int letras = 64;
        char letra = (char)0;
        char numeros=(char)49;
        int num = 48;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                //Genera las letras
                if (i == 0) {
                    tablero[0][j] = Character.toString(numeros);
                    num=num+1;
                    numeros=(char)num;
                }else {
                    tablero[i][j] = "*";
                }
                //Genera los numeros
                if (j == 0){
                    tablero[i][j] = Character.toString(letra);
                    letras = letras + 1;
                    letra = (char)letras;
                }
                //Primer cuadrado siempre NULL
                if (i == 0 && j == 0) {
                    tablero[0][0] = " ";
                }
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
