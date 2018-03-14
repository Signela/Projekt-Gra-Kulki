package pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions;

/**
 * Klasa odpowiedziala za wyrzucenie odpowiedniego komunikatu w momencie nie znalezienia pliku
 * config.properties
 */
public class NotFoundMyProperties extends Exception {
    public NotFoundMyProperties(String string) {
        System.out.println(string);
    }
}
