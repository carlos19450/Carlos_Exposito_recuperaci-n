package HundirLaFlota;

import java.util.ArrayList;

// Barco tendrá lista de objetos coordenadas
//
public class Barco {
    private String nombre;
    private int tamano;
    private int id;
    public ArrayList<Coordenadas> listaDeCoordenadas = new ArrayList<Coordenadas>();
    public ArrayList<Integer> posicionesx = new ArrayList<Integer>();
    public ArrayList<Integer> posicionesy = new ArrayList<Integer>();
    public Barco(int tamano, String nombre, int id) {
        this.tamano = tamano;
        this.nombre = nombre;
        this.id = id;
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

    public int totalDeposiciones(){
        return this.posicionesx.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Coordenadas> getListaDeCoordenadas() {
        //PARA VER TODAS LAS COORDENADAS DE LAS 'X'
        //for (Coordenadas cord : this.listaDeCoordenadas) {
        //    System.out.println(getId() + "= " + cord.getX() + " " + cord.getY());
        //}
        return listaDeCoordenadas;
    }

    public void setListaDeCoordenadas(ArrayList<Coordenadas> listaDeCoordenadas) {
        this.listaDeCoordenadas = listaDeCoordenadas;
    }

    public void posicionDeXtocadas(int posX, int posY){
        this.posicionesx.add(posX);
        this.posicionesy.add(posY);
    }

    @Override
    public String toString() {
        return "Barco{" +
                "nombre='" + nombre + '\'' +
                ", tamano=" + tamano +
                ", id=" + id +
                '}';
    }
}
