package Geometria2DyJunit;

public class Segmento {
    private Punto inicio;
    private Punto fin;
    int x1,x2,y2,y1; // BORRARLO!!!!!

    public Segmento(Punto punto1, Punto punto2) {
        this.inicio = punto1;
        this.fin = punto2;
    }

    public Segmento(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Punto getInicio() {
        return inicio;
    }

    public void setInicio(Punto inicio) {
        this.inicio = inicio;
    }

    public Punto getFin() {
        return fin;
    }

    public void setFin(Punto fin) {
        this.fin = fin;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    //FALTA IMPLEMENTAR
    public int longitudDelSegmento() {
        //Sacar distancia entre punto 1 punto 2
        return 0;
    }

    //FALTA IMPLEMENTAR
    public void setOffset(int xOffset, int yOffset) {
        /*this.x1 += xOffset;
        this.y1 += yOffset;*/
        /*this.x2 += xOffset;
        this.y2 += yOffset;*/
    }

    @Override
    public String toString() {
        return "Segmento{" +
                "inicio=" + inicio +
                ", fin=" + fin +
                ", x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}
