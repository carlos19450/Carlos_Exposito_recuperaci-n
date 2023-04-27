package Geometria2DyJunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectanguloTest {

    @Test
    void getAncho() {
        Rectangulo rectangulo = new Rectangulo(4, 2);
        assertEquals(4, rectangulo.getAncho());
    }

    @Test
    void setAncho() {
        Rectangulo rectangulo = new Rectangulo(4, 2);
        rectangulo.setAncho(8);
        assertEquals(8, rectangulo.getAncho());
    }

    @Test
    void getAlto() {
        Rectangulo rectangulo = new Rectangulo(4, 2);
        assertEquals(2, rectangulo.getAlto());
    }

    @Test
    void setAlto() {
        Rectangulo rectangulo = new Rectangulo(4, 2);
        rectangulo.setAlto(7);
        assertEquals(7, rectangulo.getAlto());
    }

    @Test
    void getArea() {
        Rectangulo rectangulo = new Rectangulo(4, 2);
        assertEquals(8, rectangulo.getArea());
    }

    @Test
    void getPerimetro() {
        Rectangulo rectangulo = new Rectangulo(4, 2);
        assertEquals(12, rectangulo.getPerimetro());
    }

    @Test
    void getPuntoInferiorIzquierdo() {
    }

    @Test
    void getPuntoSuperiorIzquierdo() {
    }

    @Test
    void getPuntoInferiorDerecho() {
    }

    @Test
    void getPuntoSuperiorDerecho() {
    }
}