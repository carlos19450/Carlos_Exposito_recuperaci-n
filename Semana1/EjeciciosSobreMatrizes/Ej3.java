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


        mostrarMatriz(n, m);
    }
    public static int[][] llenarMatriz(int n, int m) {
        Scanner sc = new Scanner(System.in);
        int [][] matriz = new int [n][m];;
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

    public static void mostrarMatriz(int n, int m) {
        int contMayorQue0 = 0;
        int contMenorQue0 = 0;
        int contIgualQue0 = 0;
        int [][] matriz;

        matriz = llenarMatriz(n, m);
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
