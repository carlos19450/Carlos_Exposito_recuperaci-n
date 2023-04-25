package EjerciciosBasicosPOOE;

import EjerciciosBasicosPOO.Articulo;

public class EjE4 {
    public static void main(String[] args) {
        Articulo articulo1 = new Articulo("Camiseta", 21, 20, 10);
        Articulo articulo2 = new Articulo("Pantalon", 10, 15, 4);
        Articulo articulo3 = new Articulo("Zapatos", 4, 40, 7);

        //ARTICULO1
        System.out.println(articulo1.getNombre() +" - Precio: "+ articulo1.getPrecio() +" - IVA: "+ articulo1.getIva() + " - PVP " + articulo1.getPVP(articulo1.getIva()) + " - PVP con descuento: "+ articulo1.getPVPDescuento(10));
        articulo1.vender(1);
        System.out.println("Vendido 1, cantidad: " + articulo1.getStock());
        articulo1.almacenar(1);
        System.out.println("Guardado 1, cantidad: " + articulo1.getStock());
        System.out.println();

        /*articulo1.setPrecio(-4);
        articulo1.setNombre("");
        articulo1.setIva(-21);
        articulo1.setStock(-4);*/

        //ARTICULO2
        System.out.println(articulo2.getNombre() +" - Precio: "+ articulo2.getPrecio() +" - IVA: "+ articulo2.getIva() + " - PVP " + articulo2.getPVP(articulo2.getIva()) + " - PVP con descuento: "+ articulo2.getPVPDescuento(articulo2.getPVP(articulo2.getIva())));
        articulo2.vender(1);
        System.out.println("Vendido 1, cantidad: " + articulo2.getStock());
        articulo2.almacenar(1);
        System.out.println("Guardado 1, cantidad: " + articulo2.getStock());
        System.out.println();

        //ARTICULO3
        System.out.println(articulo3.getNombre() +" - Precio: "+ articulo3.getPrecio() +" - IVA: "+ articulo3.getIva() + " - PVP " + articulo3.getPVP(articulo3.getIva()) + " - PVP con descuento: "+ articulo3.getPVPDescuento(articulo3.getPVP(articulo3.getIva())));
        articulo3.vender(1);
        System.out.println("Vendido 1, cantidad: " + articulo3.getStock());
        articulo3.almacenar(1);
        System.out.println("Guardado 1, cantidad: " + articulo3.getStock());
        System.out.println();
    }
}
