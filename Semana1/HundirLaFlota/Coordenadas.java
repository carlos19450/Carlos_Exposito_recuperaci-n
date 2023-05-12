package HundirLaFlota;

public class Coordenadas {
    private int x;
    private int y;
    private int longitud;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordenadas(int x, int y, int longitud) {
        this.x = x;
        this.y = y;
        this.longitud = longitud;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Coordenadas{" +
                "x=" + x +
                ", y=" + y +
                ", longitud=" + longitud +
                '}';
    }
}
