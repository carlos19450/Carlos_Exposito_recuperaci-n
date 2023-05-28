package AventuraPorConsola;

public class Arma extends Equipo {
    private int danio;

    public Arma(String nombre, int danio) {
        super(nombre, "Arma");
        this.danio = danio;
    }

    public int getDanio() {
        return danio;
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        // Aplicar el efecto del arma al personaje (aumento de fuerza)
        personaje.aumentarFuerza(danio);
    }

    @Override
    public void quitarEfecto(Personaje personaje) {
        // Quitar el efecto del arma al personaje (disminución de fuerza)
        personaje.disminuirFuerza(danio);
    }
}
