package pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions;

import javafx.scene.control.Label;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

/**
 * Klasa odpowiedzialna za zmianę komunikatu na ekranie gry na dobry ruch, w przypadku gdy gracz
 * naciśnie pole na planszy
 */
public class GoodMovement extends Exception {

    public GoodMovement(Label statement) {
        statement.setText(App.languageFile[25]);
    }
}
