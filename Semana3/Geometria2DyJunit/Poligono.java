package Geometria2DyJunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Poligono {
    private List<Punto> listaPuntos = new ArrayList<>();

    public Poligono() {
    }

    public Poligono(Punto ... punto) {
        Collections.addAll(listaPuntos, punto);
    }

    //FALTA IMPLEMENTAR
    public int getPerimetro() {
        return 0;
    }
    // se recorre todos los puntos y calculas la distancia de cada punto con el siguiente punto
    // para el último punto (que no tiene siguiente punto) calculo la distancia respecto al primer punto
    // todas estas distancias hay que sumarlas, así saco el perímetro (length)

    //FALTA IMPLEMENTAR
    public void setOffset(int xOffset, int yOffset) {
        // se recorre todos los puntos y a cada punto (TODOS!!!) le suma xOffset a la x, yOffset a la y
        // con un for

    }

    @Override
    public String toString() {
        return "Poligono{" +
                "listaPuntos=" + listaPuntos +
                '}';
    }
}
