package EjeciciosSobreMatrizes;

import java.util.Scanner;
// Revisar funcionamiento
// Pedir sexo y sueldo a la vez
// Usar sólo una matriz!!!!

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPersonas;
        Ej5PersonasTrabajadoras [][] matrizPersonasTrabajadoras;
        System.out.println("Cuantas personas queires introducir: ");
        numPersonas = sc.nextInt();

        matrizPersonasTrabajadoras = new Ej5PersonasTrabajadoras [numPersonas][1];

        llenarMatriz(matrizPersonasTrabajadoras);
        mostrarYcalcularMatrize(matrizPersonasTrabajadoras);
    }
    public static void llenarMatriz(Ej5PersonasTrabajadoras[][] matrizPersonasTrabajadoras) {
        Scanner sc = new Scanner(System.in);
        int sueldo;
        int genero;

        for (int i = 0; i < matrizPersonasTrabajadoras.length; i++) {
            for (int j = 0; j < matrizPersonasTrabajadoras[0].length; j++) {
                System.out.print("Trabajador " + (i + 1) + "\n");
                System.out.println("Introduce '0' opara varon '1' para mujer");
                System.out.println("La persona numero "+ i + " es :");
                genero = sc.nextInt();
                System.out.print("Su sueldo es de: ");
                sueldo = sc.nextInt();
                matrizPersonasTrabajadoras[i][j] = new Ej5PersonasTrabajadoras(sueldo, genero);
            }
            System.out.println();
        }
    }

    public static void mostrarYcalcularMatrize(Ej5PersonasTrabajadoras[][] matrizPersonasTrabajadoras) {
        int sueldoMedioVaron = 0;
        int sueldoMedioMujer = 0;
        int contHombres = 0;
        int contMujeres = 0;
        // Sueldo varones
        for (int i = 0; i < matrizPersonasTrabajadoras.length; i++) {
            for (int j = 0; j < matrizPersonasTrabajadoras[0].length; j++) {
                if (matrizPersonasTrabajadoras[i][j].getGenero() == 1) {
                    sueldoMedioVaron += matrizPersonasTrabajadoras[i][j].getSueldo();
                    contHombres++;
                }else {
                    sueldoMedioMujer += matrizPersonasTrabajadoras[i][j].getSueldo();
                    contMujeres++;
                }
            }
        }
        sueldoMedioVaron = sueldoMedioVaron / contHombres;
        System.out.println("El sueldo medio de los varones es : " + sueldoMedioVaron);
        System.out.println();

        sueldoMedioMujer = sueldoMedioMujer / contMujeres;
        System.out.println("El sueldo medio de las mujeres es : " + sueldoMedioMujer);
        System.out.println();
    }
}
