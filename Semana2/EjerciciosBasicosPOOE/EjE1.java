package EjerciciosBasicosPOOE;

import EjerciciosBasicosPOO.Punto;

public class EjE1 {
    public static void main(String[] args) {
        Punto coordenada1 = new Punto(5, 0);
        Punto coordenada2 = new Punto(10, 10);
        Punto coordenada3 = new Punto(-3, 7);

        coordenada1.imprime();
        coordenada2.imprime();
        coordenada3.imprime();
        System.out.println();

        coordenada1.setXY(3,4);
        coordenada2.setXY(2,1);
        coordenada3.setXY(1,1);
        coordenada1.imprime();
        coordenada2.imprime();
        coordenada3.imprime();
        System.out.println();

        coordenada1.desplaza(1,2);
        coordenada2.desplaza(2,3);
        coordenada3.desplaza(3,4);
        coordenada1.imprime();
        coordenada2.imprime();
        coordenada3.imprime();
        System.out.println();

        System.out.print("La distancia del punto a , b es:"+ coordenada1.distancia(coordenada2));

        Punto cordrng1 = Punto.creaPuntoAleatorio();
        Punto cordrng2 = Punto.creaPuntoAleatorio();

        cordrng1.imprime();
        cordrng2.imprime();
    }
}
