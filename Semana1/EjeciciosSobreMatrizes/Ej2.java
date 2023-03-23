package EjeciciosSobreMatrizes;

public class Ej2 {
    public static void main(String[] args) {
        mostrarMatriz();
    }
    public static int[][] llenarMatriz() {
        int [][] matriz = new int[10][10];
        int a = 1;
        int b = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = a * b;
                b++;
            }
            a++;
            b = 1;
        }
        return matriz;
    }

    public static void mostrarMatriz() {
        int [][] matriz;
        int cont = 1;
        matriz = llenarMatriz();
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Tabla del " + cont + " = ");
            cont++;
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
