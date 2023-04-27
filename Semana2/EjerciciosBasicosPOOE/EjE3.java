package EjerciciosBasicosPOOE;

import EjerciciosBasicosPOO.Rectangulo;

public class EjE3 {
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(1, 2, 3, 7);
        Rectangulo rectangulo2 = new Rectangulo(1, 1, 4, 5);

        System.out.println("Rectangulo 1");
        System.out.println(rectangulo1);
        System.out.println();

        rectangulo1.setX1(8);
        rectangulo1.setY1(8);
        rectangulo1.setX2(3);
        rectangulo1.setY2(3);

        System.out.println("Rectangulo 2");
        System.out.println(rectangulo2);
    }
}
