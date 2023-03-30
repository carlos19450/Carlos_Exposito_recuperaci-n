package EjerciciosBasicosPOO;

public class Articulo {
    private String nombre;
    private double iva;
    private double precio;
    private int stock;

    public Articulo(String nombre, double iva, double precio, int stock) {
        if (iva < 0  || precio < 0 || stock < 0 || nombre.equals("")) {
            System.out.println("Error. El iva o el precio o el stock son menores que 0 o el nombre esta vacio");
        }else {
            this.nombre = nombre;
            this.iva = iva;
            this.precio = precio;
            this.stock = stock;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.equals("")) {
            System.out.println("Error. El nombre esta vacio");
            this.nombre = "";
        }else {
            this.nombre = nombre;
        }
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        if (iva < 0) {
            System.out.println("Error. El iva es menor que 0");
            this.iva = 0;
        }else {
            this.iva = iva;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            System.out.println("Error. El precio es menor que 0");
            this.precio = 0;
        }else {
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Error. El stock es menor que 0");
            this.stock = 0;
        }else {
            this.stock = stock;
        }
    }

    public double getPVP(double iva) {
        return (getPrecio() * (iva / 100));
    }

    public double getPVPDescuento( double pvp) {
        return getPrecio() - pvp;
    }

    public boolean vender(int cantidadVendidos) {
        if (getStock() > cantidadVendidos) {
            setStock(getStock() - cantidadVendidos);
            return true;
        }else {
            return false;
        }

    }

    public boolean almacenar(int guardar) {
        if (guardar > 0) {
            setStock(getStock() + guardar);
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "Articulo{" +
                "nombre='" + nombre + '\'' +
                ", iva=" + iva +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
