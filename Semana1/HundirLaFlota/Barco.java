package HundirLaFlota;

import java.util.ArrayList;

public class Barco {
    private String nombre;
    private int tamano;
    private String posicion;
    public ArrayList<Integer> posicionesx=new ArrayList<Integer>();
    public ArrayList<Integer> posicionesy=new ArrayList<Integer>();
    public Barco(int tamano,String nombre,String posicion) {
        this.tamano = tamano;
        this.nombre = nombre;
        this.posicion=posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int posiciones(){
        return this.posicionesx.size();
    }

    public void tocado(int fila,int columna){
        this.posicionesx.add(fila);
        this.posicionesy.add(columna);
    }

    @Override
    public String toString() {
        return "Barco{" +
                "nombre='" + nombre + '\'' +
                ", tamano=" + tamano +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}
