package Triangulos;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int rows;

        System.out.print("Introduce el numero de lineas: ");
        rows = in.nextInt();
        printPowerOf2Triangle(rows);

        System.out.println();

        System.out.print("'Pascal'. Introduce el numero de lineas: ");
        rows = in.nextInt();
        printPascalTriangle(rows);
    }
    public static void printPowerOf2Triangle(int rows) {
        int result;
        int cont = rows - 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = cont; j > 0; j--) {
                //GENERA LOS ESPACIOS NECESARIOS
                System.out.printf(" %4s" ," ");
            }

            for (int j = 0; j <= (2 * rows); j++) {
                if (j == (rows + 1)) {
                    continue;
                }else if (j < (rows + 1))
                    result = j;
                else {
                    result = ((2 * rows) - j + 1);
                }
                if (result >= (rows + 1 - i)) {
                    System.out.printf(" %4s" , (int)Math.pow(2, (i + result - rows - 1)));
                }
            }
            cont--;
            System.out.println();
        }
    }

    public static void printPascalTriangle(int rows) {
        for(int i = 0; i < rows; i++) {
            int number = 1;
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for(int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
