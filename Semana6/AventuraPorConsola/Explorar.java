package AventuraPorConsola;

import java.util.Arrays;

public class Explorar extends Habilidad {
    private Zona[][] tablero;
    private Personaje personaje;

    public Explorar(Zona[][] tablero, Personaje personaje) {
        super("Explorar");
        this.tablero = tablero;
        this.personaje = personaje;
    }

    public Zona[][] getTablero() {
        return tablero;
    }

    public void setTablero(Zona[][] tablero) {
        this.tablero = tablero;
    }

    public String explorarZona(Personaje personaje) {
        return tablero[personaje.getPosicionX()][personaje.getPosicionY()].devolverDescripcion();
    }

    @Override
    public String realizarAccion() {
        return explorarZona(this.personaje);
    }

    @Override
    public String toString() {
        return "Explorar{" +
                "tablero=" + Arrays.toString(tablero) +
                '}';
    }
}
