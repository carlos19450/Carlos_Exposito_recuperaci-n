package AventuraPorConsola;

public class Moverse extends Habilidad{
    private String direccion;
    private Personaje personaje;

    public Moverse(Personaje personaje, String direccion) {
        super("Movimiento");
        this.personaje = personaje;
        this.direccion = direccion;
        this.comando = "mover";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String realizarAccion() {
        String estadoDelMovimiento = "Se necesita una direccion.";
        if (direccion.equalsIgnoreCase("norte")) {
            estadoDelMovimiento = moverNorte(this.personaje);
        }else if (direccion.equalsIgnoreCase("sur")) {
            estadoDelMovimiento = moverSur(this.personaje);
        }else if (direccion.equalsIgnoreCase("este")) {
            estadoDelMovimiento = moverEste(this.personaje);
        }else if (direccion.equalsIgnoreCase("oeste")) {
            estadoDelMovimiento = moverOeste(this.personaje);
        }
        return estadoDelMovimiento;
    }

    public String moverNorte(Personaje personaje) {
        String estadoDelMovimiento;
        if (personaje.getPosicionX() - 1 < 0) {
            estadoDelMovimiento = "Las montañas son demasiado altas para seguir...";
        }else {
            personaje.setPosicionX(personaje.getPosicionX() - 1);
            estadoDelMovimiento = "He andado hasta la siguiente zona (%d,%d)".formatted(personaje.getPosicionX(),personaje.getPosicionY());
        }
        return estadoDelMovimiento;
    }

    public String moverSur(Personaje personaje) {
        String estadoDelMovimiento;
        if (personaje.getPosicionX() + 1 > 3) {
            estadoDelMovimiento = "No existe mapa por seguir...";
        }else {
            personaje.setPosicionX(personaje.getPosicionX() + 1);
            estadoDelMovimiento = "He andado hasta la siguiente zona (%d,%d)".formatted(personaje.getPosicionX(),personaje.getPosicionY());
        }
        return estadoDelMovimiento;
    }

    public String moverEste(Personaje personaje) {
        String estadoDelMovimiento;
        if (personaje.getPosicionY() + 1 > 4) {
            estadoDelMovimiento = "Avanzas pero algo te devuelve donde antes...";
        }else {
            personaje.setPosicionY(personaje.getPosicionY() + 1);
            estadoDelMovimiento = "He andado hasta la siguiente zona (%d,%d)".formatted(personaje.getPosicionX(),personaje.getPosicionY());
        }
        return estadoDelMovimiento;
    }

    public String moverOeste(Personaje personaje) {
        String estadoDelMovimiento;
        if (personaje.getPosicionY() - 1 < 0) {
            estadoDelMovimiento = "Solo hay agua y no sabes nadar...";
        }else {
            personaje.setPosicionY(personaje.getPosicionY() - 1);
            estadoDelMovimiento = "He andado hasta la siguiente zona (%d,%d)".formatted(personaje.getPosicionX(),personaje.getPosicionY());
        }
        return estadoDelMovimiento;
    }

    @Override
    public String toString() {
        return "Moverse{" +
                "direccion='" + direccion + '\'' +
                '}';
    }
}
