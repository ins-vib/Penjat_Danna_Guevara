package penjat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testInicialitzarEstat() {
        String paraula = "hola";
        char[] estat = App.inicialitzarEstat(paraula);

        assertEquals(4, estat.length);

        for (char c : estat) {
            assertEquals('_', c);
        }
    }

    @Test
    void testActualitzarEstatEncert() {
        String paraula = "hola";
        char[] estat = {'_', '_', '_', '_'};

        boolean resultat = App.actualitzarEstat(estat, paraula, 'o');

        assertTrue(resultat);
        assertEquals('_', estat[0]);
        assertEquals('o', estat[1]);
        assertEquals('_', estat[2]);
        assertEquals('_', estat[3]);
    }

    @Test
    void testActualitzarEstatError() {
        String paraula = "hola";
        char[] estat = {'_', '_', '_', '_'};

        boolean resultat = App.actualitzarEstat(estat, paraula, 'z');

        assertFalse(resultat);

        for (char c : estat) {
            assertEquals('_', c);
        }
    }

    @Test
    void testParaulaCompletadaFalse() {
        char[] estat = {'h', 'o', '_', 'a'};
        assertFalse(App.paraulaCompletada(estat));
    }

    @Test
    void testParaulaCompletadaTrue() {
        char[] estat = {'h', 'o', 'l', 'a'};
        assertTrue(App.paraulaCompletada(estat));
    }
}
