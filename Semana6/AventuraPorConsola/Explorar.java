package AventuraPorConsola;

import java.util.Arrays;

public class Explorar extends Habilidad {
    private Zona[][] tablero;

    public Explorar(Zona[][] tablero) {
        super(null);
        this.tablero = tablero;
    }

    public Zona[][] getTablero() {
        return tablero;
    }

    public void setTablero(Zona[][] tablero) {
        this.tablero = tablero;
    }

    public void explorarZona(Personaje personaje) {
        System.out.println("Has encontrado " + tablero[personaje.getPosicionX()][personaje.getPosicionY()].devolverDescripcion());
    }

    @Override
    public String toString() {
        return "Explorar{" +
                "tablero=" + Arrays.toString(tablero) +
                '}';
    }
}
