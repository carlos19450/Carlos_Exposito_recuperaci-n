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
        if (direccion.equalsIgnoreCase("norte")) {
            moverNorte(this.personaje);
        }else if (direccion.equalsIgnoreCase("sur")) {
            moverSur(this.personaje);
        }else if (direccion.equalsIgnoreCase("este")) {
            moverEste(this.personaje);
        }else if (direccion.equalsIgnoreCase("oeste")) {
            moverOeste(this.personaje);
        }
        return null;
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
        if (personaje.getPosicionX() + 1 < 0) {
            estadoDelMovimiento = "No existe mapa por seguir...";
        }else {
            estadoDelMovimiento = "He andado hasta la siguiente zona (%d,%d)".formatted(personaje.getPosicionX(),personaje.getPosicionY());
        }
        personaje.setPosicionX(personaje.getPosicionX() + 1);
        return estadoDelMovimiento;
    }

    public String moverEste(Personaje personaje) {
        String estadoDelMovimiento;
        if (personaje.getPosicionY() + 1 > 5) {
            estadoDelMovimiento = "Avanzas pero algo te devuelve donde antes...";
        }else {
            estadoDelMovimiento = "He andado hasta la siguiente zona (%d,%d)".formatted(personaje.getPosicionX(),personaje.getPosicionY());
        }
        personaje.setPosicionY(personaje.getPosicionY() + 1);
        return estadoDelMovimiento;
    }

    public String moverOeste(Personaje personaje) {
        String estadoDelMovimiento;
        if (personaje.getPosicionY() + 1 < 0) {
            estadoDelMovimiento = "Solo hay agua y no sabes nadar...";
        }else {
            estadoDelMovimiento = "He andado hasta la siguiente zona (%d,%d)".formatted(personaje.getPosicionX(),personaje.getPosicionY());
        }
        personaje.setPosicionY(personaje.getPosicionY() - 1);
        return estadoDelMovimiento;
    }

    @Override
    public String toString() {
        return "Moverse{" +
                "direccion='" + direccion + '\'' +
                '}';
    }
}
