package JuegoAdivina;

public class AdivinaAnimales extends Adivina{
    private final String[] tiposDeAnimales = {"perro", "gato", "elefante", "jirafa", "tigre"};
    private final String[] pistasDeAnimales = {"Es un animal doméstico.", "Es conocido por su agilidad.",
            "Es el animal terrestre más grande.", "Tiene un largo cuello.", "Es un felino salvaje."};

    @Override
    public String[] getObjetosSecretosHeredados() {
        return tiposDeAnimales;
    }

    @Override
    public String[] getPistasHeredadas() {
        return pistasDeAnimales;
    }
}
