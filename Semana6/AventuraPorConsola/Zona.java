package AventuraPorConsola;

import java.util.Objects;

public class Zona {
    private Personaje jugador;
    private Enemigo enemigo;
    private Equipo equipo;
    Entidad entidad;

    public Zona() {

    }
    public Zona(Entidad entidad) {
        this.entidad = entidad;
    }

    public Personaje getJugador() {
        return jugador;
    }

    public void setJugador(Personaje jugador) {
        this.jugador = jugador;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public boolean hayObjeto() {
        if (enemigo != null) {
            return true;
        } else return equipo != null;
    }

    public String devolverDescripcion() {
        if (entidad != null) {
            return entidad.getDescripcion();
        } else {
            return "Parece que en esta zona no hay nada...";
        }
    }

    @Override
    public String toString() {
        String id;
        if (entidad != null) {
            id = entidad.getId();
        }else {
            id = "~";
        }
        return id;
    }
}
