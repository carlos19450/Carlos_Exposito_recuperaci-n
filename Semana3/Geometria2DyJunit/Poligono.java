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
    public int getLength() {
        return 0;
    }

    //FALTA IMPLEMENTAR
    public void setOffset(int xOffset, int yOffset) {

    }

    @Override
    public String toString() {
        return "Poligono{" +
                "listaPuntos=" + listaPuntos +
                '}';
    }
}
