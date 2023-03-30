package EjerciciosBasicosPOO;

public class Punto {
    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void imprime() {
        System.out.println("("+ x +", "+ y +")");
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void desplaza(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    public int distancia(Punto p) {
        int coordenada;

        if (getX() > p.x){
            coordenada = getX() - p.x;
        } else {
            coordenada = p.x - getY();
        }
        return coordenada;
    }

    public static Punto creaPuntoAleatorio(){
        int rng1, rng2;

        rng1 = (int) (Math.random()*200 -100);
        rng2 = (int) (Math.random()*200 -100);
        Punto p = new Punto(rng1, rng2);

        return p;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
