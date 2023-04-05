package EjeciciosSobreMatrizes;

public class Ej2 {
    public static void main(String[] args) {
        int [][] matriz = new int[10][10];
        llenarMatriz(matriz);
        mostrarMatriz(matriz);
    }
    public static int[][] llenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (i + 1) * (j + 1);
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Tabla del " + (i + 1) + " = ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
