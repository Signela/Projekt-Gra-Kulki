package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Klasa odpowiedzialna za dodanie ilustracji tła ekranu
 */
public class MyImage {

    public Label addImage(String myImage) {
        Image imageStart = new Image(myImage);
        Label labelStart = new Label();
        labelStart.setGraphic(new ImageView(imageStart));
        return labelStart;
    }
}
