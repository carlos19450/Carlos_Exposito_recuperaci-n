package EjerciciosBasicosPOOC;

import EjerciciosBasicosPOO.Articulo;

public class EjC4 {
    public static void main(String[] args) {
        Articulo articulo1 = new Articulo("Camiseta", 21, 20, 2);

        System.out.println(articulo1.getNombre() +" - Precio: "+ articulo1.getPrecio() +" - IVA: "+ articulo1.getIva() +" - PVP: "+ ((articulo1.getPrecio() * 0.21) + articulo1.getPrecio()));

        articulo1.setPrecio(-4);
        articulo1.setNombre("");
        articulo1.setIva(-21);
        articulo1.setStock(-4);

        System.out.println(articulo1.getNombre() +" - Precio: "+ articulo1.getPrecio() +" - IVA: "+ articulo1.getIva() +" - PVP: "+ ((articulo1.getPrecio() * 0.21) + articulo1.getPrecio()));
    }
}
