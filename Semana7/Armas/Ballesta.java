package Armas;

public class Ballesta extends ArmaDistancia{
    private int municion;
    private double tamanoSaeta;
    private double tamano;

    public Ballesta(int municion, double tamanoSaeta, double tamano) {
        this.municion = municion;
        this.tamanoSaeta = tamanoSaeta;
        this.tamano = tamano;
    }

    @Override
    public double hitChance() {
        return tamano / tamanoSaeta;
    }

    @Override
    public double damage() {
        return tamanoSaeta * 2;
    }

    @Override
    public int getMunition() {
        return municion;
    }
}
