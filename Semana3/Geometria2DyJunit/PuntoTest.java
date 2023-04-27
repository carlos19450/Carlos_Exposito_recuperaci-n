package Geometria2DyJunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuntoTest {

    @Test
    void getX() {
        Punto punto = new Punto(2, 2);
        assertEquals(2, punto.getX());
    }

    @Test
    void setX() {
        Punto punto = new Punto(2, 2);
        punto.setX(4);
        assertEquals(4, punto.getX());
    }

    @Test
    void getY() {
        Punto punto = new Punto(2, 2);
        assertEquals(2, punto.getY());
    }

    @Test
    void setY() {
        Punto punto = new Punto(2, 2);
        punto.setY(4);
        assertEquals(4, punto.getY());
    }

    @Test
    void moveTo() {
        Punto punto = new Punto(2, 2);
        punto.moveTo(7, 5);
        assertEquals(7, punto.getX());
        assertEquals(5, punto.getY());
    }

    @Test
    void setOffset() {
        Punto punto = new Punto(2, 2);
        punto.setOffset(4, 5);
        assertEquals(6, punto.getX());
        assertEquals(7, punto.getY());
    }
}