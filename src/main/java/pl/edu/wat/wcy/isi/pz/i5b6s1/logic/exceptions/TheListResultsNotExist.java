package pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions;

import javafx.scene.control.TextArea;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

/**
 * klasa odpowiedzialna za wyżuceniie komunikatu na ekran wyników w przypadku, gdy wyniki nie zostały
 * jeszcze załadowane
 */
public class TheListResultsNotExist extends Exception {
    public TheListResultsNotExist(TextArea textArea) {
        textArea.setText(App.languageFile[34]);
    }
}
