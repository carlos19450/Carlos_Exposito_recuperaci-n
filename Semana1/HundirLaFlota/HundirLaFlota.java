package HundirLaFlota;

import java.util.ArrayList;
import java.util.Scanner;

// 4 ESTADOS Y USAR SÓLO LA MATRIZ CON ESTADOS BARCO, AGUA, AGUA DISPARADA, BARCO DISPARADO, SÓLO LOS 2 ÚLTIMOS SE IMPRIMEN, EL RESTO ESPACIO EN BLANCO
public class HundirLaFlota {
    public static ArrayList<String> ocupadas = new ArrayList<String>();
    public static ArrayList<String> repetidas = new ArrayList<String>();
    public static String [][] tablero = new String[9][9];
    public static Coordenadas coordenada;
    public static int posx;
    public static int posy;
    public static int intentos = 0;
    public static int barcosHundidos = 0;
    public static void main(String[] args) {
        ArrayList<Barco> barcos = new ArrayList<>();
        crearTablero();
        crearBarcos(barcos);
        do{
            System.out.println("SHOOTS: " + intentos);
            System.out.println("SUNK SHIPS: " + barcosHundidos);
            mostrarTablero(barcos);
            hacerTurno(barcos);
        }while(barcosHundidos != 10);
        System.out.println();
        System.out.println("HAS HUNDIDO TODOS LOS BARCOS, TU GANAS!!!");
        crearTablero();
    }

    public static void crearTablero() {
        int letras = 64;
        char letra = (char)0;
        char numeros=(char)49;
        int num = 48;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                //Genera las letras
                if (i == 0) {
                    tablero[0][j] = Character.toString(numeros);
                    num=num+1;
                    numeros=(char)num;
                }else {
                    tablero[i][j] = " ";
                }
                //Genera los numeros
                if (j == 0){
                    tablero[i][j] = Character.toString(letra);
                    letras = letras + 1;
                    letra = (char)letras;
                }
                //Primer cuadrado siempre " "
                if (i == 0 && j == 0) {
                    tablero[0][0] = " ";
                }
            }
        }
    }

    public static void crearBarcos(ArrayList<Barco> barcos) {
        Barco barco;
        for (int i = 0; i < 2; i++){
            barco = new Barco(3,"Acorazado", i);
            genenrarOrientacionDeBarcosAleatorios(barco);
            barcos.add(barco);
        }
        for (int i = 2; i < 5; i++){
            barco = new Barco(2,"Buque", i);
            genenrarOrientacionDeBarcosAleatorios(barco);
            barcos.add(barco);
        }
        for (int i = 5; i < 9;i++){
            barco = new Barco(1,"Submarino", i);
            genenrarOrientacionDeBarcosAleatorios(barco);
            barcos.add(barco);
        }
        barco = new Barco(4,"Portaavion", 9);
        genenrarOrientacionDeBarcosAleatorios(barco);
        barcos.add(barco);

        for (Barco b : barcos) {
            System.out.println(b.getPosicionFinal());
        }
    }

    public static void mostrarTablero(ArrayList<Barco> barcos) {
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[0].length; j++){
                //bool hayunbarcoen(i,j)
                System.out.print(tablero[i][j]+"    ");
            }
            System.out.println();
        }
    }

    public static void hacerTurno(ArrayList<Barco> barcos) {
        Scanner sc = new Scanner(System.in);
        String posicionIntroducida;
        String posxy;
        System.out.println("Introduce una posicion. Ejemplo 'A2'.");
        System.out.print("  Introducir: ");
        posicionIntroducida = sc.nextLine();
        posx = esLetraCorrecta(posicionIntroducida);
        posy = Integer.parseInt(posicionIntroducida.substring(1));
        posxy = posx + "," + posy;
        if (posx == 0 || posy <= 0 || posy > 9 ){
            System.out.println("Error. Introduce una posición valida");
            System.out.println();
        }else{
            comprobarEstadoDelBarco(barcos, posxy);
        }
    }

    public static void crearCoordenadasAlosBarco(Barco barco) {
        String posicionesfinal = null;
        boolean ocupada = false;

        if(coordenada.getOrientacion().equals("derecha")){
            for(int i = coordenada.getY(); i < coordenada.getY() + coordenada.getLongitud(); i++){
                if(comprobarOcupadas(coordenada.getX(), i)){
                    ocupada = true;
                    repetidas.add(coordenada.getX() + "," + i);
                }else{
                    ocupada = false;
                    ocupadas.add(coordenada.getX() + "," + i);
                    posicionesfinal = coordenada.getX() + (",") + i + " ";
                }
            }
        }
        if(coordenada.getOrientacion().equals("abajo")){
            for(int i = coordenada.getX(); i < coordenada.getX() + coordenada.getLongitud(); i++){
                if(comprobarOcupadas(i, coordenada.getX())){
                    ocupada = true;
                    repetidas.add(coordenada.getX() + "," + i);
                }else{
                    ocupada = false;
                    ocupadas.add(" " + i + "," + coordenada.getX());
                    posicionesfinal = i + "," + coordenada.getX() + " ";
                }
            }
        }
            if (ocupada){
                genenrarOrientacionDeBarcosAleatorios(barco);
            }else{
                barco.setPosicionFinal(posicionesfinal.toString());
            }
        }

    public static void comprobarEstadoDelBarco(ArrayList<Barco> barcos, String posxy) {
        boolean tiroAcertado;
        String barcoPos;

        System.out.println();
        tiroAcertado = false;
        for(int i = 0; i < barcos.size(); i++){
            barcoPos = barcos.get(i).getPosicionFinal();
            if(barcoPos.contains(posxy)){
                tablero[posx][posy] = "";
                System.out.println("Has tocado un barco");
                tiroAcertado = true;
                barcos.get(i).tocado(posx, posy);
                if(barcos.get(i).posiciones() == barcos.get(i).getTamano()){
                    System.out.println("HUNDIDO!. Has hundido un " + barcos.get(i).getNombre());
                    barcosHundidos++;
                    for(int j = 0; j < barcos.get(i).posicionesx.size(); j++){
                        tablero[barcos.get(i).posicionesx.get(j)][barcos.get(i).posicionesy.get(j)] = "X";
                    }
                    barcos.remove(i);
                }
            }
        }
        if(!tiroAcertado){
            System.out.println("Agua");
            tablero[posx][posy] = "O";
        }
        intentos++;
    }

    public static boolean comprobarOcupadas(int x, int o){
        return ocupadas.contains(x + "," + o) || ocupadas.contains(x + "," + o + ",") || ocupadas.contains(" " + x + "," + o + ",") || ocupadas.contains(" " + x + "," + o);
    }

    public static int esLetraCorrecta(String user){
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
/* void hayBarco(i,j)
    for barcos
        for coorendedas
                x,y = i,j
            haybarco
    nohaybarco*/

    public static void genenrarOrientacionDeBarcosAleatorios(Barco barco) {
        int x = (int) (Math.random() * 8 + 1);
        int y = (int) (Math.random() * 8 + 1);
        String orientacion;
            if (x < 4 && y < 4) {
                orientacion = "derecha";
            }else if (x < 4 && y > 4) {
                orientacion = "abajo";
            } else {
                orientacion = "abajo";
            }
            coordenada = new Coordenadas(x, y, orientacion, barco.getTamano());
            crearCoordenadasAlosBarco(barco);

    }
}
