package Geometria2DyJunit;

public class Rectangulo extends Punto{
    private int ancho;
    private int alto;

    public Rectangulo(int x, int y) {
        super(x, y);
        this.ancho = 0;
        this.alto = 0;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getArea() {
        return this.alto * this.ancho;
    }

    public int getPerimetro() {
        return (this.alto * 2) + (this.ancho * 2);
    }
    @Override
    public String toString() {
        return "Rectangulo{" +
                "ancho=" + ancho +
                ", alto=" + alto +
                '}';
    }
}
