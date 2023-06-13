package AventuraPorConsola;

import java.util.Scanner;

public class JuegoAventuras {
    public static void main(String[] args) {
        boolean seguirJugando = true;
        Personaje jugador = new Personaje(3, 2, "Jugador", 1, 50, 0, 10);
        Zona[][] tablero = new Zona[4][5];
        inicializarTablero(tablero);
        System.out.println("¡Bienvenido al juego de aventuras!\n" +
                "¡Encuentra y mata al BOSS final para salvar al mundo!");
        do {
            if (jugador.getSaludTotal() <= 0 || ((Enemigo) tablero[0][2].getEntidad()).getSalud() <= 0) {
                seguirJugando = false;
            }else {
                turnoDelJugador(tablero, jugador);
            }
        }while (seguirJugando);

        if (jugador.getSaludTotal() <= 0) {
            System.out.println("Has muerto...");
        }else {
            System.out.println("¡Has salvado al mundo!");
        }
    }

    public static void inicializarTablero(Zona[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = new Zona();
            }
        }
        meterObjetosEnTablero(tablero);
    }

    public static void meterObjetosEnTablero(Zona[][] tablero) {
        Entidad arma = new Espada("!", "Espada", 15, "Has encontrado una espada afilada con una grand piedra roja y brillante.");
        Entidad escudo = new Escudo("O", "Escudo", 10, "Has encontrado un escudo blindado de platino.");
        Entidad boss = new Enemigo("≠", "Dragon", 3, 65, 10, "¡CUIDADO! ¡Parece un enemigo muy peligroso!");

        tablero[0][2] = new Zona(boss);
        tablero[2][1] = new Zona(arma);
        tablero[3][4] = new Zona(escudo);
    }

    public static void turnoDelJugador(Zona[][] tablero, Personaje jugador) {
        Scanner sc = new Scanner(System.in);
        boolean comandoValido = false;
        String[] arrayDeRespuestas;
        String accionComando;
        if (tablero[jugador.getPosicionX()][jugador.getPosicionY()] == tablero[0][2]) {
            System.out.println(tablero[jugador.getPosicionX()][jugador.getPosicionY()].getEntidad().getDescripcion());
        }
        do {
            dibujarTablero(tablero, jugador);
            System.out.print("> ");
            accionComando = sc.nextLine();
            arrayDeRespuestas = accionComando.split(" ");
            if (tablero[jugador.getPosicionX()][jugador.getPosicionY()] == tablero[0][2] && accionComando.equalsIgnoreCase("atacar")) {
                comandoValido = true;
                atacar(tablero, jugador, (Enemigo) tablero[0][2].getEntidad());
            }else {
                if (arrayDeRespuestas[0].equalsIgnoreCase("mover")) {
                    comandoValido = true;
                    moverse(arrayDeRespuestas, jugador);
                } else if (arrayDeRespuestas[0].equalsIgnoreCase("explorar")) {
                    comandoValido = true;
                    explorar(tablero, jugador);
                } else if (arrayDeRespuestas[0].equalsIgnoreCase("equipar") && tablero[jugador.getPosicionX()][jugador.getPosicionY()].entidad != null && tablero[jugador.getPosicionX()][jugador.getPosicionY()] != tablero[0][2]) {
                    comandoValido = true;
                    equipar(tablero, jugador);
                } else if (arrayDeRespuestas[0].equalsIgnoreCase("desequipar") && tablero[jugador.getPosicionX()][jugador.getPosicionY()].entidad != null && tablero[jugador.getPosicionX()][jugador.getPosicionY()] != tablero[0][2]) {
                    comandoValido = true;
                    desequipar(tablero, jugador);
                }else {
                    System.out.println("Comando no valido");
                }
            }
            System.out.println();
        } while (!comandoValido);
    }

    public static void dibujarTablero(Zona[][] tablero, Personaje jugador) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (jugador.getPosicionX() == i && jugador.getPosicionY() == j) {
                    System.out.print(jugador.getId() + " ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void moverse(String[] arrayDeRespuestas, Personaje jugador) {
        Habilidad moverse = new Moverse(jugador, arrayDeRespuestas[1]);
        System.out.println(moverse.realizarAccion());
    }

    public static void explorar(Zona[][] tablero, Personaje jugador) {
        Habilidad explorar = new Explorar(tablero, jugador);
        System.out.println(explorar.realizarAccion());
    }

    public static void equipar(Zona[][] tablero, Personaje jugador) {
        Equipo objeto = (Equipo) tablero[jugador.getPosicionX()][jugador.getPosicionY()].getEntidad();
        jugador.agregarObjeto(objeto);
        tablero[jugador.getPosicionX()][jugador.getPosicionY()].setEntidad(null);
    }

    public static void desequipar(Zona[][] tablero, Personaje jugador) {
        int cont = 0;
        int posicionDelObjeto;
        Scanner sc = new Scanner(System.in);
        System.out.println("Objetos en tu inventario: ");
        for (Equipo equipo : jugador.getEquipo()) {
            System.out.println(cont++ + ". " + equipo.getNombre());

        }
        System.out.println("¿Cual quieres desequipar?");
        posicionDelObjeto = sc.nextInt();
        Entidad objeto = jugador.getEquipo().get(posicionDelObjeto);
        tablero[jugador.getPosicionX()][jugador.getPosicionY()].setEntidad(objeto);
        jugador.quitarObjeto(jugador.getEquipo().get(posicionDelObjeto));
    }

    public static void atacar(Zona[][] tablero, Personaje jugador, Enemigo enemigo) {
        Habilidad atacar = new Atacar(tablero, jugador, enemigo);
        atacar.realizarAccion();
    }
}