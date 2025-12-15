package penjat;

import java.util.Random;
import java.util.Scanner;

public class App {

    static String[] PARAULES = {
        "hola","cadira","tisores","riu","fotografia","escala",
        "llibre","ordinador","ratoli","armari","pati","programa","columna"
    };

    static String[] DIBUIXOS = {
        """
           +---+
               |
               |
               |
              ===
        """,
        """
           +---+
           O   |
               |
               |
              ===
        """,
        """
           +---+
           O   |
           |   |
               |
              ===
        """,
        """
           +---+
           O   |
          /|   |
               |
              ===
        """,
        """
           +---+
           O   |
          /|\\  |
               |
              ===
        """,
        """
           +---+
           O   |
          /|\\  |
          /    |
              ===
        """,
        """
           +---+
           O   |
          /|\\  |
          / \\  |
              ===
        """
    };

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String paraula = obtenirParaula();
        char[] estat = inicialitzarEstat(paraula);
        int errors = 0;

        System.out.println("🎮 JOC DEL PENJAT 🎮");

        while (errors < 6 && !paraulaCompletada(estat)) {

            System.out.println("\nPARAULA:");
            mostrarEstat(estat);

            System.out.println("\nErrors: " + errors + "/6");
            mostrarNinot(errors);

            char lletra = demanarLletra();

            if (actualitzarEstat(estat, paraula, lletra)) {
                System.out.println("✔ La lletra '" + lletra + "' hi és!");
            } else {
                errors++;
                System.out.println("✘ La lletra '" + lletra + "' no hi és.");
            }
        }

        if (paraulaCompletada(estat)) {
            System.out.println("\n🎉 HAS GUANYAT! Paraula: " + paraula);
        } else {
            mostrarNinot(errors);
            System.out.println("\n💀 HAS PERDUT! Paraula: " + paraula);
        }
    }

    public static String obtenirParaula() {
        Random rnd = new Random();
        return PARAULES[rnd.nextInt(PARAULES.length)];
    }

    public static void mostrarNinot(int errors) {
        System.out.println(DIBUIXOS[errors]);
    }

    public static char demanarLletra() {
        char lletra;
        do {
            System.out.print("Entra una lletra: ");
            String entrada = scanner.nextLine().toLowerCase();
            lletra = (entrada.length() == 1) ? entrada.charAt(0) : ' ';
        } while (lletra < 'a' || lletra > 'z');
        return lletra;
    }

    public static char[] inicialitzarEstat(String paraula) {
        char[] estat = new char[paraula.length()];
        for (int i = 0; i < estat.length; i++) {
            estat[i] = '_';
        }
        return estat;
    }

    public static boolean actualitzarEstat(char[] estat, String paraula, char lletra) {
        boolean encert = false;
        for (int i = 0; i < paraula.length(); i++) {
            if (paraula.charAt(i) == lletra && estat[i] == '_') {
                estat[i] = lletra;
                encert = true;
            }
        }
        return encert;
    }

    public static void mostrarEstat(char[] estat) {
        for (char c : estat) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static boolean paraulaCompletada(char[] estat) {
        for (char c : estat) {
            if (c == '_') return false;
        }
        return true;
    }
}
