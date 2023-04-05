package EjeciciosSobreMatrizes;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;

        System.out.println("Se va a inicializar una matriz de NxM");
        System.out.println("Este es el valor 'N'");
        System.out.print("Introduce un numerico: ");
        n = sc.nextInt();
        System.out.println("Este es el valor 'M'");
        System.out.print("Introduce un numerico: ");
        m = sc.nextInt();
        System.out.println();

        int [][] matriz = new int [n][m];

        llenarMatriz(matriz);
        mostrarMatriz(matriz);
        combromarNumeroDeMatriz(matriz);
    }
    public static int[][] llenarMatriz(int[][] matriz) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println(matriz[0].length);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Mete un numerico: ");
                num = sc.nextInt();
                matriz[i][j] = num;
                System.out.println();
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void combromarNumeroDeMatriz(int[][] matriz) {
        int contMayorQue0 = 0;
        int contMenorQue0 = 0;
        int contIgualQue0 = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > 0) {
                    contMayorQue0++;
                } else if (matriz[i][j] < 0) {
                    contMenorQue0++;
                }else {
                    contIgualQue0++;
                }
            }
        }
        System.out.println();
        System.out.println("Mayor que 0 -> " + contMayorQue0 + "\n" +
                "Menor que 0 -> " + contMenorQue0 + "\n" +
                "Igual que 0 -> " + contIgualQue0);
    }
}
