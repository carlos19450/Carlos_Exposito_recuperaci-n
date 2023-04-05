package EjeciciosSobreMatrizes;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        int [][] matriz = new int [4][5];

        llenarMatriz(matriz);
        mostrarYcomprobarMatriz(matriz);
    }
    public static void llenarMatriz(int[][] matriz) {
        Scanner sc = new Scanner(System.in);
        int nota;

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Alumno " + (i + 1) + "\n");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("  Introduce tu nota de la asignatura " + j + " : ");
                nota = sc.nextInt();
                matriz[i][j] = nota;
                System.out.println();
            }
        }
    }

    public static void mostrarYcomprobarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int notaMin = 10;
            int notaMax = 0;
            int notaMedia = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > notaMax) {
                    notaMax = matriz[i][j];
                }
                if (matriz[i][j] < notaMin) {
                    notaMin = matriz[i][j];
                }
                if (matriz[i][j] == notaMin) {
                    notaMax = matriz[i][j];
                    notaMin = matriz[i][j];
                }
                notaMedia += matriz[i][j];
            }
            notaMedia = notaMedia / matriz[0].length;
            System.out.println("La nota maxima del alumno " + (i + 1) + " es : " + notaMax + "\n" +
                    "La nota minima del alumno " + (i + 1) + " es : " + notaMin + "\n" +
                    "La nota media del alumno " + (i + 1) + " es : " + notaMedia);
            System.out.println();
        }
    }
}
