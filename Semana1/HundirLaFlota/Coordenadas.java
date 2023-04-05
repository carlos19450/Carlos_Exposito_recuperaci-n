package HundirLaFlota;

public class Coordenadas {
    private int x;
    private int y;
    private String orientacion;
    private int longitud;

    public Coordenadas() {
    }
    public Coordenadas(int x, int y, String orientacion, int longitud) {
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
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

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
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
                ", orientacion='" + orientacion + '\'' +
                ", longitud=" + longitud +
                '}';
    }
}
