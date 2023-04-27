package Polinomios;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class PolinomioTest {

    @Test
    public void getGrado() {
        Polinomio p = new Polinomio(1, 2, 3);
        assertEquals(2, p.getGrado());
    }

    @Test
    void evaluar() {
        Polinomio p = new Polinomio(1.0, 2.0, 3.0);
        assertEquals(6.0, p.evaluar(1.0));
        assertEquals(17.0, p.evaluar(2.0));
    }

    @Test
    void add() {
        Polinomio p1 = new Polinomio(1, 2, 3);
        Polinomio p2 = new Polinomio(4, 5, 6);
        Polinomio resultado = p1.add(p2);
        double[] coeficientesEsperados = {5, 7, 9};
        assertArrayEquals(coeficientesEsperados, resultado.getCoeficientes());
    }

    @Test
    void multiplica() {
        Polinomio p1 = new Polinomio(1, 2, 3);
        Polinomio p2 = new Polinomio(4, 5, 6);
        Polinomio resultado = p1.multiplica(p2);
        double[] coeficientesEsperados = {4, 13, 28, 27, 18};
        assertArrayEquals(coeficientesEsperados, resultado.getCoeficientes(), 0.0001);
    }

    @Test
    void testToString() {
        Polinomio p = new Polinomio(1.23, -4.56, 7.89);
        String resultado = "7.89x^2 + -4.56x + 1.23";
        assertEquals(resultado, p.toString());
    }
}