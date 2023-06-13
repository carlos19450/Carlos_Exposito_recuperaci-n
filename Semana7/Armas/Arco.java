package Armas;

public class Arco extends ArmaDistancia{
    @Override
    public double hitChance() {
        return 0;
    }

    @Override
    public double damage() {
        return 0;
    }

    @Override
    public int getMunition() {
        return 0;
    }
}
