package AventuraPorConsola;

public class Escudo extends Equipo {
    private final String id;
    private int vida;
    private String descripcion;

    public Escudo(String id, String nombre, int vida, String descripcion) {
        super(id, nombre, "Escudo", descripcion);
        this.vida = vida;
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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
        System.out.println("Te has equipado un escudo");
        personaje.aumentarVida(vida);
    }

    @Override
    public void quitarEfecto(Personaje personaje) {
        // Quitar el efecto del arma al personaje (disminución de defensa)
        System.out.println("Te has desequipado un escudo");
        personaje.disminuirVida(vida);
    }

    @Override
    public String toString() {
        return "Escudo{" +
                "id='" + id + '\'' +
                ", vida=" + vida +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
