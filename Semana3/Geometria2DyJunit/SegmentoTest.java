package Geometria2DyJunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentoTest {

    @Test
    void getInicio() {
        Punto punto1 = new Punto();
        Punto punto2 = new Punto();
        Segmento segmento = new Segmento(punto1, punto2);
        assertEquals(punto1, segmento.getInicio());
    }

    @Test
    void setInicio() {
        Punto punto1 = new Punto();
        Punto punto2 = new Punto();
        Segmento segmento = new Segmento(punto1, punto2);
        assertEquals(punto1, segmento.getInicio());
    }

    @Test
    void getFin() {
        Punto punto1 = new Punto();
        Punto punto2 = new Punto();
        Segmento segmento = new Segmento(punto1, punto2);
        assertEquals(punto2, segmento.getFin());
    }

    @Test
    void setFin() {
        Punto punto1 = new Punto();
        Punto punto2 = new Punto();
        Segmento segmento = new Segmento(punto1, punto2);
        segmento.setFin(punto1);
        assertEquals(punto1, segmento.getFin());
    }

    @Test
    void getX1() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        assertEquals(1, segmento.getX1());
    }

    @Test
    void setX1() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        segmento.setX1(4);
        assertEquals(4, segmento.getX1());
    }

    @Test
    void getY1() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        assertEquals(3, segmento.getY1());
    }

    @Test
    void setY1() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        segmento.setY1(8);
        assertEquals(8, segmento.getY1());
    }

    @Test
    void getX2() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        assertEquals(5, segmento.getX2());
    }

    @Test
    void setX2() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        segmento.setX2(7);
        assertEquals(7, segmento.getX2());
    }

    @Test
    void getY2() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        assertEquals(2, segmento.getY2());
    }

    @Test
    void setY2() {
        Segmento segmento = new Segmento(1, 3, 5, 2);
        segmento.setY2(1);
        assertEquals(1, segmento.getY2());
    }

    @Test
    void longitudDelSegmento() {
    }

    @Test
    void setOffset() {

    }
}