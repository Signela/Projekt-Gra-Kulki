package pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

/**
 * Klasa odpowiedzialna za wyrzucenie komunikatu na ekranie w przypadku gdy podano złe hasło użytkownika
 */
public class WrongPassword extends  Exception{
    public WrongPassword(Label label){
        label.setText(App.languageFile[9]);
        label.setFont(Font.font(20));
    }
}
