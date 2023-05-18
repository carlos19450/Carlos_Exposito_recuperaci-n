package HundirLaFlota;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {
    public static ArrayList<String> ocupadas = new ArrayList<String>();
    public static ArrayList<String> repetidas = new ArrayList<String>();
    public static String[][] tablero = new String[9][9];
    public static int posx;
    public static int posy;
    public static int intentos = 0;
    public static int barcosHundidos = 0;

    public static void main(String[] args) {
        ArrayList<Barco> barcos = new ArrayList<>();
        crearTablero();
        crearBarcos(barcos);
        System.out.println("Bienvenido a 'HUNDIR LA FLOTA', para ganar hunde 10 barcos.\n" +
                "Si necesita ayuda escriba 'info'\n");
        do {
            System.out.println("SHOOTS: " + intentos);
            System.out.println("SUNK SHIPS: " + barcosHundidos);
            mostrarTablero(barcos);
            hacerTurno(barcos);
        } while (barcosHundidos != 10);
        System.out.println();
        System.out.println("HAS HUNDIDO TODOS LOS BARCOS, TU GANAS!!!");
    }

    public static void crearTablero() {
        int letras = 64;
        char letra = (char) 0;
        char numeros = (char) 49;
        int num = 48;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                //Genera las letras
                if (i == 0) {
                    tablero[0][j] = Character.toString(numeros);
                    num = num + 1;
                    numeros = (char) num;
                } else {
                    tablero[i][j] = " ";
                }
                //Genera los numeros
                if (j == 0) {
                    tablero[i][j] = Character.toString(letra);
                    letras = letras + 1;
                    letra = (char) letras;
                }
                //Primer cuadrado siempre " "
                if (i == 0 && j == 0) {
                    tablero[0][0] = " ";
                }
            }
        }
    }

    public static void crearBarcos(ArrayList<Barco> barcos) {
        int id = 0;
        Barco barco;
        barco = new Barco(4, "Portaavion", id++);

        /*
        Debes hacer algo asi cada vez que creaOrientacion pero en un meodo nuevo
        Coordenadas coordenada = new Coordenadas(x, y, barco.getTamano());
        crearCoordenadasAlBarco(barco, orientacion, coordenada);
        while (!comprobarSiCoordenadasBarcoLibres(barco)) {
            crearCoordenadasAlBarco(barco, orientacion, coordenada);
        }
        introducirBarcoEnTablero(barco);*/

        crearOrientacion(barco);
        barcos.add(barco);

        for (int i = 0; i < 2; i++) {
            barco = new Barco(3, "Acorazado", id++);
            crearOrientacion(barco);
            barcos.add(barco);
        }
        for (int i = 0; i < 3; i++) {
            barco = new Barco(2, "Buque", id++);
            crearOrientacion(barco);
            barcos.add(barco);
        }
        for (int i = 0; i < 4; i++) {
            barco = new Barco(1, "Submarino", id++);
            crearOrientacion(barco);
            barcos.add(barco);
        }
        //PARA VER TODAS LAS COORDENADAS DE LAS 'X'
        /*for (Barco b : barcos) {
            b.getListaDeCoordinates();
        }*/
    }

    public static void mostrarTablero(ArrayList<Barco> barcos) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static void hacerTurno(ArrayList<Barco> barcos) {
        Scanner sc = new Scanner(System.in);
        String posicionIntroducida;
        String posxy;
        System.out.println("Introduce una posicion. Ejemplo 'A2'. Para más informacion del juego escriba 'info'");
        System.out.print("  Introducir: ");
        posicionIntroducida = sc.nextLine();
        System.out.println();
        if (posicionIntroducida.equalsIgnoreCase("Info")) {
            System.out.println("Existen 4 tipos de barcos \n" +
                    "   Portavion con tamaño 'X X X X'\n" +
                    "   Acorazado con tamaño 'X X X'\n" +
                    "   Buque con tamaño 'X X'\n" +
                    "   Submarino con tamaño 'X'\n" +
                    "!Acaba con ellos¡\n");
        } else {
            posx = esLetraCorrecta(posicionIntroducida);
            posy = Integer.parseInt(posicionIntroducida.substring(1));
            posxy = posx + "," + posy;
            if (posx == 0 || posy <= 0 || posy > 8) {
                System.out.println("Error. Introduce una posición valida");
                System.out.println();
            } else {
                disparar(barcos, posxy);
            }
        }
    }

    public static void crearCoordenadasAlBarco(Barco barco, String orientacion, Coordenadas coordenada) {
        boolean ocupada = false;

        if (orientacion.equals("derecha")) {
            for (int i = coordenada.getY(); i < coordenada.getY() + coordenada.getLongitud(); i++) {
                for (int j = 0; j < tablero[0].length; j++) {
                    barco.listaDeCoordenadas.add(new Coordenadas(coordenada.getX(), i));
                }
            }
        }
    }

    public static void crearOrientacion(Barco barco) { // cambiar nombre está posicionando las coordenadas de un barco, esta colocando un barco en el tablero
        String orientacion = null;
        Random random = new Random();
        int x, y;
        //if ((random.nextInt(2)) == 0) {
        orientacion = "derecha";
        x = random.nextInt(8 - barco.getTamano() + 1) + 1;
        y = random.nextInt(8) + 1;
        //} else {
        //  orientacion = "abajo";
        // lo mismo que arriba pero la x por la y
        //}

        //System.out.println("barco creado");
        //System.out.println(barco.listaDeCoordenadas);
    }

    public static boolean comprobarSiCoordenadasBarcoLibres(Barco barco) {
        boolean estanLibres = true;
        for (Coordenadas coordenada : barco.getListaDeCoordenadas()) {
            if (!Objects.equals(tablero[coordenada.getX()][coordenada.getY()], " ")) {
                estanLibres = false;
                break;
            }
        }
        return estanLibres;
    }
    public static void introducirBarcoEnTablero(Barco barco) {
        boolean estanLibres = true;dispararBarco
        for (Coordenadas coordenada: barco.getListaDeCoordenadas()) {
            //System.out.println(barco);
            tablero[coordenada.getX()][coordenada.getY()] = String.valueOf(barco.getId());
        }
    }


    public static void disparar(ArrayList<Barco> barcos, String posxy) {

        // no hay un barco -> pon una 0 en la posicion disparada
        // hay barco -> pon una X y llamas a dispararBarco() que lo que hará es actualizar el estado del barco
        boolean tiroAcertado = false;
        String barcoPos;

        System.out.println();
        for (int i = 0; i < barcos.size(); i++) {
            for (Coordenadas cord : barcos.get(i).getListaDeCoordenadas()) {
                barcoPos = cord.getX() + "," + cord.getY();
                if (barcoPos.contains(posxy)) {
                    tablero[posx][posy] = "";
                    System.out.println("###### Has tocado un barco ######");
                    tiroAcertado = true;
                    barcos.get(i).posicionDeXtocadas(posx, posy);
                    if (barcos.get(i).totalDeposiciones() == barcos.get(i).getTamano()) {
                        System.out.println("HUNDIDO!. Has hundido un " + barcos.get(i).getNombre());
                        barcosHundidos++;
                        for (int j = 0; j < barcos.get(i).posicionesx.size(); j++) {
                            tablero[barcos.get(i).posicionesx.get(j)][barcos.get(i).posicionesy.get(j)] = "X";
                        }
                        barcos.remove(i);
                    }
                }
            }
        }
        if (!tiroAcertado && !Objects.equals(tablero[posx][posy], "X")) {
            System.out.println("Agua");
            tablero[posx][posy] = "O";
        }
        intentos++;
    }

    public static boolean comprobarOcupadas(int x, int o) {
        return ocupadas.contains(x + "," + o) || ocupadas.contains(x + "," + o + ",") || ocupadas.contains(" " + x + "," + o + ",") || ocupadas.contains(" " + x + "," + o);
    }

    public static int esLetraCorrecta(String user) {
        return switch (user.substring(0, 1).toLowerCase()) {
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> 0;
        };
    }
}
