package AventuraPorConsola;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private final String id;
    private String nombre;
    private int nivel;
    private int saludTotal;
    private int defensa;
    private int fuerza;
    private int posicionX;
    private int posicionY;
    private List<Equipo> equipo;
    private List<Habilidad> habilidades;

    public Personaje(int x, int y, String nombre, int nivel, int saludTotal, int defensa, int fuerza) {
        this.posicionX = x;
        this.posicionY = y;
        this.id = "1";
        this.nombre = nombre;
        this.nivel = nivel;
        this.saludTotal = saludTotal;
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
    }

    public void quitarHabilidad(Habilidad habilidad) {
        this.habilidades.remove(habilidad);
    }

    public void aumentarFuerza(int danio) {
        this.fuerza += danio;
    }

    public void disminuirFuerza(int danio) {
        this.fuerza -= danio;
    }

    public void aumentarVida(int vida) {
        this.saludTotal += vida;
    }

    public void disminuirVida(int vida) {
        this.saludTotal -= vida;
    }

    @Override
    public String toString() {
        return "PERSONAJE" + "\n" +
                "\tId: " + id + "\n" +
                "\tNombre: " + nombre + "\n" +
                "\tNivel: " + nivel + "\n" +
                "\tSaludTotal: " + saludTotal + "\n" +
                "\tFuerza: " + fuerza + "\n" +
                "\tPosicionX: " + posicionX + "\n" +
                "\tPosicionY: " + posicionY + "\n";
    }
}
