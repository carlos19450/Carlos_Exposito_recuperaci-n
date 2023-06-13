package Armas;

public class Martillo extends Arma{
    private double peso;
    private double tamano;

    public Martillo(double peso, double tamano) {
        this.peso = peso;
        this.tamano = tamano;
    }

    public double getWeight() {
        return peso;
    }

    public double getSize() {
        return tamano;
    }

    @Override
    public double hitChance() {
        return (int) (1 / peso + (1 - 0.5 / tamano));
    }

    @Override
    public double damage() {
        return peso * 2;
    }
}
