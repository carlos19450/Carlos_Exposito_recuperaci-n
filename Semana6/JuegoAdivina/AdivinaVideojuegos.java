package JuegoAdivina;

public class AdivinaVideojuegos extends Adivina{
    private final String[] tiposDeVideojuegos = {"accion", "aventura", "deportivo", "estrategia", "FPS"};
    private final String[] pistasDeVideojuegos = {"Corre, salta, esquiva y no mires atras.", "Historia cronologica con duelos.", "¡Entrena esos musculos y gana torneos!", "Piensa bien tu jugada...", "Ten cuidado con tu cabeza y la mirilla de los enemigos."};

    @Override
    public String[] getObjetosSecretosHeredados() {
        return tiposDeVideojuegos;
    }

    @Override
    public String[] getPistasHeredadas() {
        return pistasDeVideojuegos;
    }
}
