package HundirLaFlota;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class HundirLaFlota {
    public static ArrayList<String> ocupadas=new ArrayList<String>();
    public static ArrayList<String> repetidas=new ArrayList<String>();
    public static ArrayList<String> posfinal=new ArrayList<String>();
    public static String [][] tablero = new String[9][9];
    public static String user;
    public static int posx;
    public static int posy;
    public static void main(String[] args) {
        ArrayList<Barco> barcos= new ArrayList<Barco>();
        Scanner teclado=new Scanner(System.in);
        int intentos=0;

        //GENERACION DE BARCOS
        for (int i = 0; i < 2; i++){
            genenarOrientacionDeBarcosAleatorios(3);
            Barco barc=new Barco(3,"Acorazado",posfinal.get(i));
            barcos.add(barc);
        }
        for (int i = 2; i < 5; i++){
            genenarOrientacionDeBarcosAleatorios(2);
            Barco barc=new Barco(2,"Buque",posfinal.get(i));
            barcos.add(barc);
        }
        for (int i = 5; i < 9;i++){
            genenarOrientacionDeBarcosAleatorios(1);
            Barco barc=new Barco(1,"Submarino",posfinal.get(i));
            barcos.add(barc);
        }
        genenarOrientacionDeBarcosAleatorios(4);
        Barco barc=new Barco(4,"Portaavion",posfinal.get(9));
        barcos.add(barc);

        for(int i=0;i<barcos.size();i++){
            System.out.println(barcos.get(i).toString());
        }
        do{
            System.out.println(barcos.size()+" "+barcos.toString());
            System.out.println("Dime posicion primero letra y despues numero");
            user=teclado.nextLine();
            posx=letraanum(user);
            posy=Integer.parseInt(user.substring(1));
            String posxy=posx+","+posy;
            System.out.println(posxy);
            if (posx==0 || posy>10 ){
                System.out.println("Tienes que irntroducir una posición válida" + posx+posy);
            }else{
                boolean comprobacion=false;
                for(int i=0;i<barcos.size();i++){
                    String barcopos=barcos.get(i).getPosicion();
                    if(barcopos.contains(posxy)==true){
                        tablero[posx][posy]="+";
                        System.out.println("Bien has dado a un barco");
                        comprobacion=true;
                        barcos.get(i).tocado(posx, posy);
                        if(barcos.get(i).posiciones()==barcos.get(i).getTamano()){
                            System.out.println("HUNDIDOOOOO!!");
                            System.out.println("Has hundido un "+barcos.get(i).getNombre());
                            for(int o=0;o<barcos.get(i).posicionesx.size();o++){
                                tablero[barcos.get(i).posicionesx.get(o)][barcos.get(i).posicionesy.get(o)]="X";
                            }
                            barcos.remove(i);
                        }
                    }
                }
                if(comprobacion==false){
                    System.out.println("Agua");
                    tablero[posx][posy]=Character.toString((char)126);
                }
            }
            crearTablero();
            intentos ++;
            if(barcos.size()==0){
                break;
            }

        }while(intentos!=25);

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
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void genenarOrientacionDeBarcosAleatorios(int logitud) {
        int x = (int) (Math.random() * 10 + 1);
        int y = (int) (Math.random() * 10 + 1);
        int orientacion = (int) (Math.random() * 2 + 1);
        String orientado = "";
        if (x < 5 && y < 5) {
            if (orientacion == 1) {
                orientado = "derecha";
            } else {
                orientado = "abajo";
            }
        } else if (x > 5 && y > 5) {
            if (orientacion == 1) {
                orientado = "izquierda";
            } else {
                orientado = "arriba";
            }
        } else if (x > 5 && y < 5) {
            orientado = "arriba";
        } else if (x < 5 && y > 5) {
            orientado = "abajo";
        } else {
            if (orientacion == 1) {
                orientado = "izquierda";
            } else {
                orientado = "arriba";
            }
        }
        generarposiciones(x,y,orientado,logitud);
    }
    public static void generarposiciones(int x, int y, String orientado, int longitud){
        String posicionesfinal="";
        String posfallidas="";
        int conterr=0;
        if(orientado=="derecha"){
            for(int o=y;o<y+longitud;o++){
                if(comprobar(x,o)==true){
                    conterr=1;
                    repetidas.add(Integer.toString(x)+","+Integer.toString(o));
                }else{
                    ocupadas.add(Integer.toString(x)+","+Integer.toString(o));
                    posicionesfinal=posicionesfinal+Integer.toString(x)+","+Integer.toString(o)+" ";
                }
            }
        }
        if(orientado=="izquierda"){
            for(int o=y;o>y-longitud;o--){
                if(comprobar(x,o)==true){
                    conterr=1;
                    repetidas.add(Integer.toString(x)+","+Integer.toString(o));
                }else{
                    ocupadas.add(Integer.toString(x)+","+Integer.toString(o));
                    posicionesfinal=posicionesfinal+Integer.toString(x)+","+Integer.toString(o)+" ";
                }
            }
        }
        if(orientado=="abajo"){
            for(int o=x;o<x+longitud;o++){
                if(comprobar(o,x)==true){
                    conterr=1;
                    repetidas.add(Integer.toString(x)+","+Integer.toString(o));
                }else{
                    ocupadas.add(" "+Integer.toString(o)+","+Integer.toString(x));
                    posicionesfinal=posicionesfinal+Integer.toString(o)+","+Integer.toString(x)+" ";
                }
            }
        }
        if(orientado=="arriba"){
            for(int o=x;o>x-longitud;o--){
                if(comprobar(o,x)==true){
                    conterr=1;
                    repetidas.add(Integer.toString(x)+","+Integer.toString(o));
                }else{
                    ocupadas.add(Integer.toString(o)+","+Integer.toString(x));
                    posicionesfinal=posicionesfinal+Integer.toString(o)+","+Integer.toString(x)+" ";
                }
            }
        }
        if (conterr==1){
            genenarOrientacionDeBarcosAleatorios(longitud);
        }else{
            posfinal.add(posicionesfinal);
            //System.out.println(posicionesfinal);
        }
        //System.out.println(posfallidas);
    }
    public static boolean comprobar(int x,int o){
        String pos = Integer.toString(x)+","+Integer.toString(o);
        String pos2 = Integer.toString(x)+","+Integer.toString(o)+",";
        String pos3 = " "+Integer.toString(x)+","+Integer.toString(o)+",";
        String pos4 = " "+Integer.toString(x)+","+Integer.toString(o);
        if(ocupadas.contains(pos)==true || ocupadas.contains(pos2)==true || ocupadas.contains(pos3)==true ||ocupadas.contains(pos4)==true){
            return true;
        }else{
            return false;
        }
    }

    public static int letraanum(String user){
        if("A".equals(user.substring(0,1))||"a".equals(user.substring(0,1))){
            return 1;
        }else if("B".equals(user.substring(0,1))||"b".equals(user.substring(0,1))){
            return 2;
        }else if("C".equals(user.substring(0,1))||"c".equals(user.substring(0,1))){
            return 3;
        }else if("D".equals(user.substring(0,1))||"d".equals(user.substring(0,1))){
            return 4;
        }else if("E".equals(user.substring(0,1))||"e".equals(user.substring(0,1))){
            return 5;
        }else if("F".equals(user.substring(0,1))||"f".equals(user.substring(0,1))){
            return 6;
        }else if("G".equals(user.substring(0,1))||"g".equals(user.substring(0,1))){
            return 7;
        }else if("H".equals(user.substring(0,1))||"h".equals(user.substring(0,1))){
            return 8;
        }else if("I".equals(user.substring(0,1))||"i".equals(user.substring(0,1))){
            return 9;
        }else if("J".equals(user.substring(0,1))||"j".equals(user.substring(0,1))){
            return 10;
        }else{
            return 0;
        }
    }
}
