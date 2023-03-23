package EjeciciosSobreMatrizes;

public class Ej1 {
    public static void main(String[] args) {
        mostrarMatriz();
    }
    public static int[][] llenarMatriz() {
        int [][] matriz = new int[5][5];

        int cont = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = cont++;
            }
        }
        return matriz;
    }

    public static void mostrarMatriz() {
        int [][] matriz;
        matriz = llenarMatriz();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
