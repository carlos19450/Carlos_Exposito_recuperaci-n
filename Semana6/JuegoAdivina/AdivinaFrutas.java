package JuegoAdivina;

import java.util.Random;

public class AdivinaFrutas extends Adivina{
    private final String[] tiposDeFrutas = {"manzana", "naranja", "plátano", "uva", "sandía"};
    private final String[] pistasDeFrutas = {"Es de color rojo o verde.", "Es cítrica.", "Es alargada y amarilla.", "Es pequeña y redonda.", "Es una fruta grande y jugosa."};

    @Override
    public String[] getObjetosSecretosHeredados() {
        return tiposDeFrutas;
    }

    @Override
    public String[] getPistasHeredadas() {
        return pistasDeFrutas;
    }
}
