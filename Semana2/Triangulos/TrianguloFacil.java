package Triangulos;

public class TrianguloFacil {
    public static void main(String[] args) {
        int rows = 5;
        int acum;
        for (int i = 0; i <= rows; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print(" ");
            }
            acum = i;
            for (int j = 0; j <= i; j++) {
                System.out.print(acum--);
            }
            acum = i;
            for (int j = 0; j <= i; j++) {
                System.out.print(acum--);
            }
            System.out.println();
        }
    }
}
