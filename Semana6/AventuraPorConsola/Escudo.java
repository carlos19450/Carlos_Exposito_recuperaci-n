package AventuraPorConsola;

public class Escudo extends Equipo {
    private String id;
    private int defensa;
    private String descripcion;

    public Escudo(String id, String nombre, int defensa, String descripcion) {
        super(id, nombre, "Escudo", descripcion);
        this.defensa = defensa;
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "Escudo{" +
                "id='" + id + '\'' +
                ", defensa=" + defensa +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
