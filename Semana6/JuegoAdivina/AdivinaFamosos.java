package JuegoAdivina;

public class AdivinaFamosos extends Adivina{
    private final String[] famosos = {"willyRex", "messi", "shakira", "picasso", "rubius"};
    private final String[] pistasDeFamosos = {"El padre de Youtube de habla hispana.", "ME SSIrve.", "CLARA mente el agua se bebe.", "Pintor y escultor famosos y español.", "Hola criaturitas del señor."};

    @Override
    public String[] getObjetosSecretosHeredados() {
        return famosos;
    }

    @Override
    public String[] getPistasHeredadas() {
        return pistasDeFamosos;
    }
}
