package AventuraPorConsola;

public class Escudo extends Equipo {
    private int defensa;
    public Escudo(String nombre, int defensa) {
        super(nombre, "Escudo");
        this.defensa = defensa;
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        // Aplicar el efecto del arma al personaje (aumento de fuerza)
        personaje.aumentarDefensa(defensa);
    }

    @Override
    public void quitarEfecto(Personaje personaje) {
        // Quitar el efecto del arma al personaje (disminución de defensa)
        personaje.disminuirDefensa(defensa);
    }
}
