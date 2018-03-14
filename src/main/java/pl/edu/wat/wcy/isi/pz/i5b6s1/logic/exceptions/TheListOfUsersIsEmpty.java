package pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

/**
 * Klasa odpowiedzialna za zwrócenie informacji o tym, że lista użytkowników nie została jeszcze
 * wygenerowana przez bazę danych, lub nie istnieje
 */
public class TheListOfUsersIsEmpty extends Exception {
    public TheListOfUsersIsEmpty(Label label) {
        label.setText(App.languageFile[26] + "\n" + App.languageFile[32]);
        label.setFont(Font.font(16));
    }
}