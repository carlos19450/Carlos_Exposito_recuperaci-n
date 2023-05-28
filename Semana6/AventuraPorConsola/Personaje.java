package AventuraPorConsola;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private final String id;
    private String nombre;
    private int nivel;
    private int saludTotal;
    private int saludRestante;
    private int defensa;
    private int fuerza;
    private int posicionX;
    private int posicionY;
    private List<Equipo> equipo;
    private List<Habilidad> habilidades;

    public Personaje(String nombre, int nivel, int saludTotal, int defensa, int fuerza) {
        this.id = "1";
        this.nombre = nombre;
        this.nivel = nivel;
        this.saludTotal = saludTotal;
        this.saludRestante = saludTotal;
        this.defensa = defensa;
        this.fuerza = fuerza;
        this.equipo = new ArrayList<>();
        this.habilidades = new ArrayList<>();
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

    public int getSaludTotal() {
        return saludTotal;
    }

    public void setSaludTotal(int saludTotal) {
        this.saludTotal = saludTotal;
    }

    public int getSaludRestante() {
        return saludRestante;
    }

    public void setSaludRestante(int saludRestante) {
        this.saludRestante = saludRestante;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Equipo> equipo) {
        this.equipo = equipo;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public void agregarObjeto(Equipo equipo) {
        this.equipo.add(equipo);
        equipo.aplicarEfecto(this);
    }

    public void quitarObjeto(Equipo equipo) {
        this.equipo.remove(equipo);
        equipo.quitarEfecto(this);
    }

    public void agregarHabilidad(Habilidad habilidad) {
        this.habilidades.add(habilidad);
        habilidad.aplicarEfecto(this);
    }

    public void quitarHabilidad(Habilidad habilidad) {
        this.habilidades.remove(habilidad);
        habilidad.quitarEfecto(this);
    }

    public void moverse(Habilidad moverse) {
        this.habilidades.add(moverse);
        moverse.moverse(this);
    }

    public void atacar(Enemigo enemigo) {
        // Lógica para atacar a un enemigo
        System.out.println("Has atacado al enemigo: " + enemigo.getNombre());
        enemigo.setSalud(enemigo.getSalud() - this.fuerza);
    }

    public void aumentarFuerza(int danio) {
        this.fuerza += danio;
    }

    public void disminuirFuerza(int danio) {
        this.fuerza -= danio;
    }

    public void aumentarDefensa(int defensa) {
        this.defensa += defensa;
    }

    public void disminuirDefensa(int defensa) {
        this.defensa -= defensa;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nNivel: " + nivel +
                "\nSalud: " + saludRestante + "/" + saludTotal +
                "\nDefensa: " + defensa +
                "\nFuerza: " + fuerza +
                "\nEquipo: " + equipo +
                "\nHabilidades: " + habilidades;
    }
}
