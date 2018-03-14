package pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions;

import javafx.scene.control.Label;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

/**
 * Klasa odpowiedzialna przedstawienie na ekranie gry komunikatu, o kliknięciu poza obszar gry
 * (w miejsce gdzie wykonanie ruchu jest niemożliwe)
 */
public class ImpossibleMovement extends Exception {
    public ImpossibleMovement(Label statement) {
        statement.setText(App.languageFile[24]);
    }
}
