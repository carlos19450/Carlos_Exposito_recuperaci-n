package Polinomios;

import java.util.Arrays;

public class Polinomio {
    private double[] coeficientes;

    public Polinomio(double... coef) {
        coeficientes = Arrays.copyOf(coef, coef.length);
    }

    public double[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(double[] coeficientes) {
        this.coeficientes = coeficientes;
    }

    public int getGrado() {
        return coeficientes.length - 1;
    }

    public double evaluar(double x) {
        double resultado = 0;
        for (int i = coeficientes.length - 1; i >= 0; i--) {
            resultado = resultado * x + coeficientes[i];
        }
        return resultado;
    }

    public Polinomio add(Polinomio otro) {
        int gradoMaximo  = Math.max(this.getGrado(), otro.getGrado());
        double[] coef = new double[gradoMaximo  + 1];

        for (int i = 0; i <= gradoMaximo ; i++) {
            if (i <= this.getGrado()) {
                coef[i] += this.coeficientes[i];
            }
            if (i <= otro.getGrado()) {
                coef[i] += otro.coeficientes[i];
            }
        }

        return new Polinomio(coef);
    }

    public Polinomio multiplica(Polinomio otro) {
        int gradoMaximo = this.getGrado() + otro.getGrado();
        double[] coef = new double[gradoMaximo + 1];

        for (int i = 0; i <= this.getGrado(); i++) {
            for (int j = 0; j <= otro.getGrado(); j++) {
                coef[i+j] += this.coeficientes[i] * otro.coeficientes[j];
            }
        }

        return new Polinomio(coef);
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = coeficientes.length - 1; i >= 0; i--) {
            if (coeficientes[i] != 0) {
                if (i == 0) {
                    resultado += coeficientes[i];
                } else if (i == 1) {
                    resultado += coeficientes[i] + "x + ";
                } else {
                    resultado += coeficientes[i] + "x^" + i + " + ";
                }
            }
        }
        return resultado;
    }
}
