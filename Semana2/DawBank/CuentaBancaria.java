package DawBank;

public class CuentaBancaria {
    private String iban;
    private String titular;
    private double saldo;
    private int contmov;
    private double movimientos[] = new double[100];
    public static final int saldoinferior = -50;
    public static final int saldosuperior = 3000;

    public CuentaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
        this.contmov = 0;
    }

    public String getiban() {
        return iban;
    }

    public String gettitular() {
        return titular;
    }

    public double getsaldo() {
        return saldo;
    }

    public void getmov(double mov[]) {
        for (int i = 0; i < this.movimientos.length; i++) {
            mov[i] = this.movimientos[i];
        }
    }

    public void ingresar(double saldo) {
        if (saldo > saldosuperior) {
            System.out.println("AVISO: Notificar a hacienda.");
        } else {
            this.movimientos[contmov] = saldo;
            this.contmov++;
            this.saldo += saldo;
        }
    }

    public void retirar(double saldo) {
        if ((this.saldo - saldo) < -50) {
            System.out.println("No puede tener su saldo en menos de -50.");
        }else {
            if ((this.saldo - saldo) < 0) {
                System.out.println("AVISO: Saldo negativo.");
                this.movimientos[contmov] = -1 * saldo;
                this.contmov++;
                this.saldo -= saldo;
            } else {
                this.movimientos[contmov] = -1 * saldo;
                this.contmov++;
                this.saldo -= saldo;
            }
        }
    }
}
