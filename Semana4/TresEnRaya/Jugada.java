package TresEnRaya;

public class Jugada {
    private int tipoDeJugada = -1;
    private int fila;
    private int columna;

    public Jugada() {
    }

    public Jugada(int tipoDeJugada, int fila, int columna) {
        this.tipoDeJugada = tipoDeJugada;
        this.fila = fila;
        this.columna = columna;
    }

    public int getTipoDeJugada() {
        return tipoDeJugada;
    }

    public void setTipoDeJugada(int tipoDeJugada) {
        this.tipoDeJugada = tipoDeJugada;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Jugada{" +
                "tipoDeJugada=" + tipoDeJugada +
                ", fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
