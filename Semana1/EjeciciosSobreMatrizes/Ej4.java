package EjeciciosSobreMatrizes;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {

        mostrarMatriz();
    }
    public static int[][] llenarMatriz() {
        Scanner sc = new Scanner(System.in);
        int [][] matriz = new int [4][5];
        int nota;
        int cont = 1;

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Alumno " + cont + "\n");
            cont++;
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("  Introduce tu nota de la asignatura " + j + " : ");
                nota = sc.nextInt();
                matriz[i][j] = nota;
                System.out.println();
            }
        }
        return matriz;
    }

    public static void mostrarMatriz() {
        int [][] matriz;
        int cont = 1;

        matriz = llenarMatriz();
        for (int i = 0; i < matriz.length; i++) {
            int notaMin = 10;
            int notaMax = 0;
            int notaMedia = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > notaMax) {
                    notaMax = matriz[i][j];
                }
                if (matriz[i][j] < notaMin) {
                    System.out.println("Entro");
                    notaMin = matriz[i][j];
                }
                if (matriz[i][j] == notaMin) {
                    notaMax = matriz[i][j];
                    notaMin = matriz[i][j];
                }
                notaMedia += matriz[i][j];
            }
            notaMedia = notaMedia / matriz[0].length;
            System.out.println("La nota maxima del alumno " + cont + " es : " + notaMax + "\n" +
                    "La nota minima del alumno " + cont + " es : " + notaMin + "\n" +
                    "La nota media del alumno " + cont + " es : " + notaMedia);
            System.out.println();
            cont++;
        }
    }
}
