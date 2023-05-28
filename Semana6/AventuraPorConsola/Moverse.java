package AventuraPorConsola;

public class Moverse extends Habilidad{
    private String direccion;
    private Zona[][] tablero;

    public Moverse(String direccion, Zona[][] tablero) {
        super("Movimiento");
        this.direccion = direccion;
        this.tablero = tablero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Zona[][] getTablero() {
        return tablero;
    }

    public void setTablero(Zona[][] tablero) {
        this.tablero = tablero;
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
}
