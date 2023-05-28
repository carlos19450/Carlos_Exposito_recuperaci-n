package AventuraPorConsola;

public class Zona {
    private int x;
    private int y;
    private Personaje jugador;
    private Enemigo enemigo;

    public Zona() {
    }

    public Zona(int x, int y, Personaje jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
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

    public Personaje getJugador() {
        return jugador;
    }

    public void setJugador(Personaje jugador) {
        this.jugador = jugador;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public String getDatos() {
        if (jugador != null) {
            return jugador.toString();
        } else if (enemigo != null) {
            return enemigo.toString();
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        if (jugador != null) {
            return jugador.getId(); // Símbolo para representar un objeto en la zona
        } else if (enemigo != null) {
            return enemigo.getId(); // Símbolo para representar un enemigo en la zona
        } else {
            return "~"; // Símbolo para representar una zona vacía
        }
    }
}
