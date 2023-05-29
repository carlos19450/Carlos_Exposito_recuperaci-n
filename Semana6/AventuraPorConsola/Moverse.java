package AventuraPorConsola;

public class Moverse extends Habilidad{
    private String direccion;

    public Moverse(String direccion) {
        super("Movimiento");
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void moverse(Personaje personaje) {
        if (direccion.equalsIgnoreCase("norte")) {
            personaje.setPosicionX(personaje.getPosicionX() - 1);
        } else if (direccion.equalsIgnoreCase("este")) {
            personaje.setPosicionY(personaje.getPosicionY() + 1);
        } else if (direccion.equalsIgnoreCase("sur")) {
            personaje.setPosicionX(personaje.getPosicionX() + 1);
        }else {
            personaje.setPosicionY(personaje.getPosicionY() - 1);
        }
    }

    @Override
    public String toString() {
        return "Moverse{" +
                "direccion='" + direccion + '\'' +
                '}';
    }
}
