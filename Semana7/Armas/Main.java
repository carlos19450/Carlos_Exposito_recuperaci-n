package Armas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Arma> weapons = new ArrayList<>();
        weapons.add(new Martillo(5, 10));
        weapons.add(new Espada(8, 6, 1));
        int enemyHealth = 100;

        for (Arma weapon : weapons) {
            while (true) {
                if (weapon.hitChance() > Math.random()) {
                    enemyHealth -= weapon.damage();
                    if (enemyHealth <= 0) {
                        System.out.println("El enemigo fue derrotado con un(a) " + weapon.getClass().getSimpleName());
                        break;
                    }
                }
            }
            enemyHealth = 100; // Reiniciar la salud del enemigo para el siguiente arma
        }
    }
}
