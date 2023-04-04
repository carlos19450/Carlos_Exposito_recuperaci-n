package HundirLaFlota;

import java.util.ArrayList;
import java.util.Scanner;

// 4 ESTADOS Y USAR SÓLO LA MATRIZ CON ESTADOS BARCO, AGUA, AGUA DISPARADA, BARCO DISPARADO, SÓLO LOS 2 ÚLTIMOS SE IMPRIMEN, EL RESTO ESPACIO EN BLANCO
public class HundirLaFlota {
    public static ArrayList<String> ocupadas = new ArrayList<String>();
    public static ArrayList<String> repetidas = new ArrayList<String>();
    public static ArrayList<String> posfinal = new ArrayList<String>();
    public static String [][] tablero = new String[9][9];
    public static int posx;
    public static int posy;
    public static void main(String[] args) {
        ArrayList<Barco> barcos = new ArrayList<Barco>();
        Scanner sc = new Scanner(System.in);
        Barco barco;
        int intentos = 0;
        int barcosHundidos = 0;
        boolean tiroAcertado;
        String posicionIntroducida;
        String posxy;
        String barcoPos;
        //CREAMOS EL TABLERO
        crearTablero();

        //GENERACION DE BARCOS
        for (int i = 0; i < 2; i++){
            genenrarOrientacionDeBarcosAleatorios(3);
            barco = new Barco(3,"Acorazado", posfinal.get(i));
            barcos.add(barco);
        }
        for (int i = 2; i < 5; i++){
            genenrarOrientacionDeBarcosAleatorios(2);
            barco = new Barco(2,"Buque", posfinal.get(i));
            barcos.add(barco);
        }
        for (int i = 5; i < 9;i++){
            genenrarOrientacionDeBarcosAleatorios(1);
            barco = new Barco(1,"Submarino", posfinal.get(i));
            barcos.add(barco);
        }
        genenrarOrientacionDeBarcosAleatorios(4);
        barco = new Barco(4,"Portaavion", posfinal.get(9));
        barcos.add(barco);

        do{
            System.out.println("SHOOTS: " + intentos);
            System.out.println("SUNK SHIPS: " + barcosHundidos);
            mostrarTablero();
            System.out.println("Introduce una posicion. Ejemplo 'A2'.");
            System.out.print("  Introducir: ");
            posicionIntroducida = sc.nextLine();
            posx = esLetraCorrecta(posicionIntroducida);
            posy = Integer.parseInt(posicionIntroducida.substring(1));
            posxy = posx + "," + posy;
            if (posx == 0 || posy <= 0 || posy > 10 ){
                System.out.println("Error. Introduce una posición valida" + posx + posy);
            }else{
                tiroAcertado = false;
                for(int i = 0; i < barcos.size(); i++){
                    barcoPos = barcos.get(i).getPosicion();
                    if(barcoPos.contains(posxy)){
                        tablero[posx][posy] = "*";
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
                //Primer cuadrado siempre NULL
                if (i == 0 && j == 0) {
                    tablero[0][0] = " ";
                }
            }
        }
    }

    public static void genenrarOrientacionDeBarcosAleatorios(int logitud) {
        int x = (int) (Math.random() * 8 + 1);
        int y = (int) (Math.random() * 8 + 1);
        int orientacion = (int) (Math.random() * 2 + 1);
        String orientado;
        if (x < 4 && y < 4) {
            if (orientacion == 1) {
                orientado = "derecha";
            } else {
                orientado = "abajo";
            }
        } else if (x > 4 && y > 4) {
            if (orientacion == 1) {
                orientado = "izquierda";
            } else {
                orientado = "arriba";
            }
        } else if (x > 4 && y < 4) {
            orientado = "arriba";
        } else if (x < 4 && y > 4) {
            orientado = "abajo";
        } else {
            if (orientacion == 1) {
                orientado = "izquierda";
            } else {
                orientado = "arriba";
            }
        }
        generarPosiciones(x,y,orientado,logitud);
    }
    public static void generarPosiciones(int x, int y, String orientado, int longitud){
        StringBuilder posicionesfinal= new StringBuilder();
        boolean correcto = false;

        if(orientado.equals("derecha")){
            for(int i = y; i < y + longitud; i++){
                if(comprobarOcupadas(x, i)){
                    correcto = true;
                    repetidas.add(x + "," + i);
                }else{
                    correcto = false;
                    ocupadas.add(x + "," + i);
                    posicionesfinal.append(x).append(",").append(i).append(" ");
                }
            }
        }
        if(orientado.equals("izquierda")){
            for(int i = y; i > y - longitud; i--){
                if(comprobarOcupadas(x, i)){
                    correcto = true;
                    repetidas.add(x + "," + i);
                }else{
                    correcto = false;
                    ocupadas.add(x + "," + i);
                    posicionesfinal.append(x).append(",").append(i).append(" ");
                }
            }
        }
        if(orientado.equals("abajo")){
            for(int i = x; i < x + longitud; i++){
                if(comprobarOcupadas(i, x)){
                    correcto = true;
                    repetidas.add(x + "," + i);
                }else{
                    correcto = false;
                    ocupadas.add(" " + i + "," + x);
                    posicionesfinal.append(i).append(",").append(x).append(" ");
                }
            }
        }
        if(orientado.equals("arriba")){
            for(int i = x; i > x - longitud; i--){
                if(comprobarOcupadas(i, x)){
                    correcto = true;
                    repetidas.add(x + "," + i);
                }else{
                    correcto = false;
                    ocupadas.add(i + "," + x);
                    posicionesfinal.append(i).append(",").append(x).append(" ");
                }
            }
        }
        if (correcto){
            genenrarOrientacionDeBarcosAleatorios(longitud);
        }else{
            posfinal.add(posicionesfinal.toString());
        }
    }
    public static boolean comprobarOcupadas(int x,int o){
        return ocupadas.contains(x + "," + o) || ocupadas.contains(x + "," + o + ",") || ocupadas.contains(" " + x + "," + o + ",") || ocupadas.contains(" " + x + "," + o);
    }

    public static int esLetraCorrecta(String user){
        return switch (user.substring(0, 1)) {
            case "A", "a" -> 1;
            case "B", "b" -> 2;
            case "C", "c" -> 3;
            case "D", "d" -> 4;
            case "E", "e" -> 5;
            case "F", "f" -> 6;
            case "G", "g" -> 7;
            case "H", "h" -> 8;
            default -> 0;
        };
    }

    public static void mostrarTablero(){
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[0].length; j++){
                System.out.print(tablero[i][j]+"    ");
            }
            System.out.println();
        }
    }
}
