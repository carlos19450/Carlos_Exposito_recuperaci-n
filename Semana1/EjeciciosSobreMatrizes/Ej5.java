package EjeciciosSobreMatrizes;

import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int genero;
        int contVaron = 0;
        int contMujer = 0;
        int numPersonas;
        int [][] matrizVarones;
        int [][] matrizMujeres;

        System.out.println("Cuantas personas queires introducir: ");
        numPersonas = sc.nextInt();

        for (int i = 1; i <= numPersonas; i++) {
            System.out.println("Introduce '0' opara varon '1' para mujer");
            System.out.println("La persona numero "+ i + " es :");
            genero = sc.nextInt();
            if (genero == 0) {
                contVaron++;
            } else if (genero == 1) {
                contMujer++;
            }
        }

        matrizVarones = new int [contVaron][1];
        matrizMujeres = new int [contMujer][1];

        mostrarMatrizes(matrizVarones, matrizMujeres);
    }
    public static int[][] llenarMatrizVaron(int[][] matrizVarones) {
        Scanner sc = new Scanner(System.in);
        int cont = 1;
        int sueldo;

        for (int i = 0; i < matrizVarones.length; i++) {
            System.out.print("Trabajador " + cont + "\n");
            cont++;
            for (int j = 0; j < matrizVarones[0].length; j++) {
                System.out.print("Su sueldo es de: ");
                sueldo = sc.nextInt();
                matrizVarones[i][j] = sueldo;
                System.out.println();
            }
        }
        return matrizVarones;
    }

    public static int[][] llenarMatrizMujer(int[][] matrizMujeres) {
        Scanner sc = new Scanner(System.in);
        int cont = 1;
        int sueldo;
        for (int i = 0; i < matrizMujeres.length; i++) {
            System.out.print("Trabajadora " + cont + "\n");
            cont++;
            for (int j = 0; j < matrizMujeres[0].length; j++) {
                System.out.print("Su sueldo es de: ");
                sueldo = sc.nextInt();
                matrizMujeres[i][j] = sueldo;
                System.out.println();
            }
        }
        return matrizMujeres;
    }

    public static void mostrarMatrizes(int[][] matrizVarones, int[][] matrizMujeres) {
        int sueldoMedioVaron = 0;
        int sueldoMedioMujer = 0;

        matrizVarones = llenarMatrizVaron(matrizVarones);
        matrizMujeres = llenarMatrizMujer(matrizMujeres);
        // Sueldo varones
        for (int i = 0; i < matrizVarones.length; i++) {
            for (int j = 0; j < matrizVarones[0].length; j++) {
                sueldoMedioVaron += matrizVarones[i][j];
            }
        }
        sueldoMedioVaron = sueldoMedioVaron / (matrizVarones[0].length + 1);
        System.out.println("El sueldo medio de los varones es : " + sueldoMedioVaron);
        System.out.println();

        // Sueldo mujeres
        for (int i = 0; i < matrizMujeres.length; i++) {
            for (int j = 0; j < matrizMujeres[0].length; j++) {
                sueldoMedioMujer += matrizMujeres[i][j];
            }
        }
        sueldoMedioMujer = sueldoMedioMujer / (matrizMujeres[0].length + 1);
        System.out.println("El sueldo medio de las mujeres es : " + sueldoMedioMujer);
        System.out.println();
    }
}
