package JuegoAdivina;

import java.util.Random;

public abstract class Adivina {
    protected String objetoSecreto;
    protected String pista;
    protected String[] objetosSecretos;
    protected String[] pistas;
    protected int puntos = 100;

    public String getObjetoSecreto() {
        return objetoSecreto;
    }

    public void setObjetoSecreto(String objetoSecreto) {
        this.objetoSecreto = objetoSecreto;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public String[] getObjetosSecretos() {
        return objetosSecretos;
    }

    public void setObjetosSecretos(String[] objetosSecretos) {
        this.objetosSecretos = objetosSecretos;
    }

    public String[] getPistas() {
        return pistas;
    }

    public void setPistas(String[] pistas) {
        this.pistas = pistas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void generarObjetoSecreto(){
        Random random = new Random();
        int indice = random.nextInt(getObjetosSecretosHeredados().length);
        objetoSecreto = getObjetosSecretosHeredados()[indice];
        pista = getPistasHeredadas()[indice];
    }

    public void mostrarPista() {
        System.out.println("Pista: " + pista);
        setPuntos(getPuntos() - 1);
    }

    public boolean adivinarObjetoSecreto(String objeto) {
        boolean adivinado = false;
        if (objeto.equalsIgnoreCase(objetoSecreto)) {
            adivinado = true;
            System.out.println("¡Felicidades! ¡Has adivinado el objeto secreto!");
        } else {
            System.out.println("Lo siento, no has adivinado el objeto secreto. ¡Inténtalo de nuevo!\n");
            setPuntos(getPuntos() / 2);
        }
        return adivinado;
    }

    public abstract String[] getObjetosSecretosHeredados();

    public abstract String[] getPistasHeredadas();
}
