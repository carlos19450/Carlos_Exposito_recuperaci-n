package AventuraPorConsola;

public class Atacar extends Habilidad {
    private Zona[][] tablero;
    private Personaje personaje;
    private Enemigo enemigo;
    public Atacar(Zona[][] tablero, Personaje personaje, Enemigo enemigo) {
        super("Batallar");
        this.tablero = tablero;
        this.personaje = personaje;
        this.enemigo = enemigo;
    }

    @Override
    public String realizarAccion() {
        return batallar(this.personaje);
    }

    public String batallar(Personaje jugador) {
        System.out.println(enemigo.toString());
        enemigo.setSalud(enemigo.getSalud() - jugador.getFuerza());
        System.out.println(enemigo.toString());
        System.out.println(jugador);
        jugador.setSaludTotal((jugador.getSaludTotal() + jugador.getDefensa()) - enemigo.getDano());
        System.out.println(jugador);
        return null;
    }
}
