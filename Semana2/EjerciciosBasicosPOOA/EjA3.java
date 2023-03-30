package EjerciciosBasicosPOOA;

import EjerciciosBasicosPOO.Rectangulo;

public class EjA3 {
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(2, 2, 4, 4);
        Rectangulo rectangulo2 = new Rectangulo(1, 1, 2, 2);

        System.out.println("Las coordenados del rectangulo 1 son: (" + rectangulo1.getX1() + "," + rectangulo1.getY1() + ")(" + rectangulo1.getX2() + "," + rectangulo1.getY2() + ")");
        System.out.println("El perimetro del rectangulo 1 es: " + ((rectangulo1.getX2() + rectangulo1.getY2()) * 2));
        System.out.println("El area del rectangulo 1 es: " + (rectangulo1.getX1() * rectangulo1.getY1()));
        System.out.println();

        System.out.println("Las coordenados del rectangulo 2 son: (" + rectangulo2.getX1() + "," + rectangulo2.getY1() + ")(" + rectangulo2.getX2() + "," + rectangulo2.getY2() + ")");
        System.out.println("El perimetro del rectangulo 2 es: " + ((rectangulo2.getX2() + rectangulo2.getY2()) * 2));
        System.out.println("El area del rectangulo 2 es: " + (rectangulo2.getX1() * rectangulo2.getY1()));
    }
}
