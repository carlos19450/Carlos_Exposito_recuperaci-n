package JuegoAdivina;

import java.util.Random;

public class AdivinaFrutas extends Adivina{
    private String[] frutas = {"manzana", "naranja", "plátano", "uva", "sandía"};
    private String[] pistas = {"Es de color rojo o verde.", "Es cítrica.", "Es alargada y amarilla.", "Es pequeña y redonda.", "Es una fruta grande y jugosa."};

    // hacer un contructor y rellenar los objetos y pistas

    /*@Override
    public void generarObjetoSecreto() {
        Random random = new Random();
        int indice = random.nextInt(frutas.length);
        objetoSecreto = frutas[indice];
        pista = pistas[indice];
    }

    @Override
    public void adivinarObjetoSecreto(String fruta) {
        if (objetoSecreto.equalsIgnoreCase(fruta)) {
            System.out.println("¡Sí, es la fruta secreta!");
        } else {
            System.out.println("No, no es la fruta secreta.");
        }
    }*/
}
