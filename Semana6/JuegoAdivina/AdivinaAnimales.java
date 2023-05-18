package JuegoAdivina;

import java.util.Random;

public class AdivinaAnimales extends Adivina{
    private String[] animales = {"perro", "gato", "elefante", "jirafa", "tigre"};
    private String[] pistas = {"Es un animal doméstico.", "Es conocido por su agilidad.",
            "Es el animal terrestre más grande.", "Tiene un largo cuello.", "Es un felino salvaje."};

    /*@Override
    public void generarObjetoSecreto() {
        Random random = new Random();
        int indice = random.nextInt(animales.length);
        objetoSecreto = animales[indice];
        pista = pistas[indice];
    }

    @Override
    public void adivinarObjetoSecreto(String objeto) {
        if (objetoSecreto.equalsIgnoreCase(objeto)) {
            System.out.println("¡Sí, es el animal secreto!");
        } else {
            System.out.println("No, no es el animal secreto.");
        }
    }*/

}
