package DawBank;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DawBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        int contmov = 0;
        String iban;
        String titular;
        double ingresar;
        double retirar, mov[] = new double[100];
        boolean verdad;

        do {
            verdad = true;
            System.out.println("Introduce un IBAN.");
            System.out.print("Introducir: ");
            iban = sc.nextLine();
            System.out.println();
            if (iban.matches("[A-Z]{2}\\d{2} ? \\d{4} ? \\d{4} ? \\d{4} ? \\d{4} ? \\d{4} ?")) {
                verdad = true;
                System.out.println("Bien, el IBAN " + iban + " es un IBAN válido.\n");
            } else {
                System.err.println("Error. El IBAN es incorrecto porfavor introduce un IBAN válido 'yyxx xxxx xxxx xxxx xxxx xxxx'.\n");
                verdad = false;
            }
        } while (!verdad);

        do {
            verdad = true;
            System.out.println("Introduce el nombre del titutal.");
            System.out.print("Introducir: ");
            titular = sc.nextLine();
            System.out.println();

            //Comprueba si el nombre contiene numeros.
            for (int i = 0; i < titular.length(); i++) {
                if (!Character.isAlphabetic((titular.charAt(i)))) {
                    verdad = false;
                }
            }
            if (verdad) {
                verdad = true;
                System.out.println("Bien, el nombre " + titular + " es un nombre válido.\n");
            } else {
                System.err.println("Error. Un nombre no puede tener nuemros...\n");
                verdad = false;
            }
        } while (!verdad);

        //Instanciamos un objeto Cuenta
        CuentaBancaria cuenta1 = new CuentaBancaria(iban, titular);

        do {
            System.out.println("");
            System.out.println("-----MENU-----");
            System.out.println("1. Datos de la cuenta.\n"
                    + "2. IBAN.\n"
                    + "3. Titular.\n"
                    + "4. Saldo.\n"
                    + "5. Ingreso.\n"
                    + "6. Retirada.\n"
                    + "7. Movimientos.\n"
                    + "8. Salir.");
            System.out.print("Introduzca el numero que representa la opcion del menu: ");
            menu = sc.nextInt();

            System.out.println();
            switch (menu) {
                case 1:
                    System.out.println("Datos de la cuenta:\n"
                            + "Iban: " + cuenta1.getiban() + "\n"
                            + "Nombre: " + cuenta1.gettitular() + "\n"
                            + "Saldo: " + cuenta1.getsaldo() + "€");
                    break;

                case 2:
                    System.out.println("Iban: " + cuenta1.getiban());
                    break;

                case 3:
                    System.out.println("Nombre: " + cuenta1.gettitular());
                    break;

                case 4:
                    System.out.println("Saldo: " + cuenta1.getsaldo() + "€");
                    break;

                case 5:
                    System.out.println("Ingresar: ");
                    do {
                        verdad = true;
                        ingresar = sc.nextInt();
                        if (ingresar > 0) {
                            verdad = true;
                            cuenta1.ingresar(ingresar);
                            if (cuenta1.getsaldo() + ingresar <= cuenta1.saldosuperior) {
                                contmov++;
                            }
                        } else {
                            verdad = false;
                            System.err.println("Error. Numero negativo invalido.");
                        }
                    } while (!verdad);
                    break;

                case 6:
                    System.out.println("Retirar: ");
                    do {
                        verdad = true;
                        retirar = sc.nextInt();
                        if (retirar > 0) {
                            verdad = true;
                            cuenta1.retirar(retirar);
                            if (cuenta1.getsaldo() - retirar <= cuenta1.saldoinferior) {
                                contmov++;
                            } else {
                                verdad = false;
                                System.err.println("Error. El saldo minimo permitido es -50.");
                            }
                        } else {
                            verdad = false;
                            System.err.println("Error. Numero negativo invalido.");
                        }
                    } while (!verdad);
                    break;

                case 7:
                    cuenta1.getmov(mov);

                    if (contmov > 0) {
                        for (int i = 0; i < contmov; i++) {
                            System.out.println("Movimientos: " + mov[i] + "€");
                        }
                    } else {
                        System.out.println("No hay movimientos.");
                    }
                    break;
                case 8:
                    break;
                default:
                    System.err.println("Error. Has introducido un numero que no esta en el menu. Introduce un numero del menu.");
            }
        } while (menu != 8);
    }
}
