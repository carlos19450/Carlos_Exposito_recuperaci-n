package AventuraPorConsola;

import java.util.ArrayList;
import java.util.List;

public class Enemigo extends Entidad{
    private final String id;
    private String nombre;
    private int nivel;
    private int salud;
    private List<Habilidad> habilidades;
    private int dano;
    private String descripcion;
    public Enemigo(String id, String nombre, int nivel, int salud, int dano, String descripcion) {
        super(id, nombre, descripcion);
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.dano = dano;
        this.habilidades = new ArrayList<>();
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Enemigo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", salud=" + salud +
                ", habilidades=" + habilidades +
                ", dano=" + dano +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
