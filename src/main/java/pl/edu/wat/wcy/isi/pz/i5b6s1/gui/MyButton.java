package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 * Klasa odpowiedzialna za stworzenie zaprojektowanego przeze mnie guzika (to znaczy, takiego który
 * ma kolor, tekt na guziki jak i wyświetlany dopiero po najechaniu na niego
 */
public class MyButton {
    private String title, toolTipText, colorButton;

    public MyButton(String title, String toolTipText, String colorButton) {
        this.title = title;
        this.toolTipText = toolTipText;
        this.colorButton = colorButton;
    }

    public Button createButton() {
        Button button = new Button(title);
        Tooltip tooltip = new Tooltip(toolTipText);
        Tooltip.install(button, tooltip);
        button.setStyle("-fx-font: 20 arial; -fx-base: " + colorButton);
        return button;
    }
}
