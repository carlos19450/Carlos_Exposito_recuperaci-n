package Armas;

public class Espada extends Arma{
    private double tamano;
    private double peso;
    private double filo;

    public Espada(double tamano, double peso, double filo) {
        this.tamano = tamano;
        this.peso = peso;
        this.filo = filo;
    }

    @Override
    public double hitChance() {
        return tamano / (peso + filo);
    }

    @Override
    public double damage() {
        return peso + filo;
    }
}
