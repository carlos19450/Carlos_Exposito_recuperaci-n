package EjerciciosBasicosPOOD;

import EjerciciosBasicosPOO.Articulo;

public class EjD4 {
    public static void main(String[] args) {
        Articulo articulo1 = new Articulo("Camiseta", 21, 20, 10);

        System.out.println(articulo1.getNombre() +" - Precio: "+ articulo1.getPrecio() +" - IVA: "+ articulo1.getIva() + " - PVP " + articulo1.getPVP() + " - PVP con descuento: "+ articulo1.getPVPDescuento(articulo1.getPVP()));
        articulo1.vender(1);
        System.out.println("Vendido 1, cantidad: " + articulo1.getStock());
        articulo1.almacenar(1);
        System.out.println("Guardado 1, cantidad: " + articulo1.getStock());
        System.out.println();

        /*articulo1.setPrecio(-4);
        articulo1.setNombre("");
        articulo1.setIva(-21);
        articulo1.setStock(-4);*/

        System.out.println(articulo1.getNombre() +" - Precio: "+ articulo1.getPrecio() +" - IVA: "+ articulo1.getIva() + " - PVP " + articulo1.getPVP() + " - PVP con descuento: "+ articulo1.getPVPDescuento(articulo1.getPVP()));
        articulo1.vender(2);
        System.out.println("Vendido 1, cantidad: " + articulo1.getStock());
        articulo1.almacenar(2);
        System.out.println("Guardado 1, cantidad: " + articulo1.getStock());
    }
}
