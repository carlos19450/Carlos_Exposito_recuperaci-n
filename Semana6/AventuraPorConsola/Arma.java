package AventuraPorConsola;

public class Arma extends Equipo {
    private String id;
    private int danio;
    private String descripcion;

    public Arma(String id, String nombre, int danio, String descripcion) {
        super(id, nombre, "Arma", descripcion);
        this.danio = danio;
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        // Aplicar el efecto del arma al personaje (más fuerza)
        personaje.aumentarFuerza(danio);
    }

    @Override
    public void quitarEfecto(Personaje personaje) {
        // Quitar el efecto del arma al personaje (menos fuerza)
        personaje.disminuirFuerza(danio);
    }

    @Override
    public String toString() {
        return "Arma{" +
                "id='" + id + '\'' +
                ", danio=" + danio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
