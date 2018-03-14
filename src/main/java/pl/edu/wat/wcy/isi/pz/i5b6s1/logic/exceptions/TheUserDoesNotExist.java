package pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

/**
 * Klasa odpowiedzialna za ustawienie komunikatu na ekranie w przypadku gdy wpisany użytkownik
 * nie istnieje (błędny login)
 */
public class TheUserDoesNotExist extends Exception {
    public TheUserDoesNotExist(Label label) {
        label.setText(App.languageFile[10]);
        label.setFont(Font.font(18));
    }
}
