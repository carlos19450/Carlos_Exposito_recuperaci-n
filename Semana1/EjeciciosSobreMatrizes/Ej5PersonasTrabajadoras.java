package EjeciciosSobreMatrizes;

public class Ej5PersonasTrabajadoras {
    private int sueldo;
    private int genero;

    public Ej5PersonasTrabajadoras(int sueldo, int genero) {
        this.sueldo = sueldo;
        this.genero = genero;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Ej5PersonasTrabajadoras{" +
                "sueldo=" + sueldo +
                ", genero=" + genero +
                '}';
    }
}
