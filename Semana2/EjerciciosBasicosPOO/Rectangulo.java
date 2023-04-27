package EjerciciosBasicosPOO;

public class Rectangulo {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private final int min = 0;

    private final int max = 100;

    public Rectangulo(int x1, int y1, int x2, int y2) {
        if (x1 > min && x1 < max && y1 > min && y1 < max && x2 > min && x2 < max && y2 > min && y2 < max) {
            if (x1 != x2 && y1 != y2) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            }else {
                System.err.println("Error. Al instanciar Rectangulo...");
            }
        }else {
            System.err.println("Error. Las coordenadas tienen que estar entre (0,0) y (100,100)");
        }
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        if (x1 != this.x1) {
            this.x1 = x1;
        } else {
            System.err.println("Error. Has introducido x1 igual que x1 anterior");
        }
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        if (y1 != this.y2) {
            this.y1 = y1;
        } else {
            System.err.println("Error. Has introducido x1 igual que x1 anterior");
        }
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        if (x2 != this.x1) {
            this.x2 = x2;
        } else {
            System.err.println("Error. Has introducido x1 igual que x1 anterior");
        }
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        if (y2 != this.y1) {
            this.y2 = y2;
        } else {
            System.err.println("Error. Has introducido x1 igual que x1 anterior");
        }
    }

    public void setX1Y1(int x1, int y1) {
        if (x1 != this.y2 || y1 != this.y2) {
            this.x1 = x1;
            this.y1 = y1;
        } else {
            System.err.println("Error. Has introducido x1 igual que x2 anterior o has introducido y1 igual que y2");
        }
    }

    public void X2Y2(int x2, int y2) {
        if (x2 != this.y1 || y2 != this.y1) {
            this.x2 = x2;
            this.y2 = y2;
        } else {
            System.err.println("Error. Has introducido x2 igual que x1 anterior o has introducido y2 igual que y1");
        }
    }

    public void setAll(int x1, int y1, int x2, int y2) {
        if (x2 != this.y1 || y2 != this.y1 || x1 != this.y2 || y1 != this.y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        } else {
            System.err.println("Error. Has introducido x2 igual que x1 anterior o has introducido y2 igual que y1 o has introducido x1 igual que x2 anterior o has introducido y1 igual que y2");
        }
    }

    public double getPerimetro() {
        Punto p1 = new Punto(x1, y1);
        return p1.distancia(new Punto(x2, y1)) * 2 + p1.distancia(new Punto(x1, y2)) * 2;
    }

    public double getArea() {
        Punto p1 = new Punto(x1, y1);
        return p1.distancia(new Punto(x2, y1)) * p1.distancia(new Punto(x1, y2));
    }

    @Override
    public String toString() {
        return  "Las coordenados del rectangulo son: " + x1 +
                ", " + y1 +
                ", " + x2 +
                ", " + y2 +
                "\n" +
                "El perimetro del rectangulo es: " + getPerimetro() +
                "\n" +
                "El area del rectangulo es: " + getArea();
    }
}
