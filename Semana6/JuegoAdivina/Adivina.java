package JuegoAdivina;

import java.util.Random;

public class Adivina {
    protected String objetoSecreto;
    protected String pista;
    protected String[] objetosSecretos;
    protected String[] pistas;
    public void generarObjetoSecreto(){
        Random random = new Random();
        int indice = random.nextInt(objetosSecretos.length);
        objetoSecreto = objetosSecretos[indice];
        pista = pistas[indice];
    }

    public void mostrarPista() {
        System.out.println("Pista: " + pista);
    }

    public void adivinarObjetoSecreto(String objeto) {
        if (objeto.equalsIgnoreCase(objetoSecreto)) {
            System.out.println("¡Felicidades! ¡Has adivinado el objeto secreto!");
        } else {
            System.out.println("Lo siento, no has adivinado el objeto secreto. ¡Inténtalo de nuevo!");
        }
    }

}
