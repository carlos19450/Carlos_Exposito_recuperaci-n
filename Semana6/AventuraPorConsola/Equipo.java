package AventuraPorConsola;

public class Equipo{
    private String nombre;
    private String tipo;

    public Equipo(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void aplicarEfecto(Personaje personaje) {
    }

    public void quitarEfecto(Personaje personaje) {
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nTipo: " + tipo;
    }
}
