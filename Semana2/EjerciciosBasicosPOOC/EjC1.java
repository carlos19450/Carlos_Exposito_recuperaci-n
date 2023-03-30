package EjerciciosBasicosPOOC;

import EjerciciosBasicosPOO.Punto;

public class EjC1 {
    public static void main(String[] args) {
        Punto coordenada1 = new Punto(5, 0);
        Punto coordenada2 = new Punto(10, 10);
        Punto coordenada3 = new Punto(-3, 7);

        System.out.println(coordenada1);
        System.out.println(coordenada2);
        System.out.println(coordenada3);
        System.out.println();
        coordenada1.setX(coordenada1.getX() - 2);
        coordenada1.setY(coordenada1.getY() + 4);

        coordenada2.setX(coordenada2.getX() / 2);
        coordenada2.setY(coordenada2.getY() * 2);

        coordenada3.setX(coordenada3.getX() - 5);
        coordenada3.setY(coordenada3.getY() + 6);

        System.out.println(coordenada1);
        System.out.println(coordenada2);
        System.out.println(coordenada3);
    }
}
