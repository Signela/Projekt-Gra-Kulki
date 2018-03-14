package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Klasa odpowiedzialna za zbudowanie takiego kwadraciku, który zawiera w sobie informację o
 * numerze kwadracika, kolorze kulki która znajduje się na kwadraciku, czy wgl jakaś kulka się znajduje
 * oraz pole Rectangle do zbudowania kwadracika na ekranie
 */
public class MyRectangle {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    Rectangle rectangle;
    Color colorCircle;
    Boolean haveCircle;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Color getColorCircle() {
        return colorCircle;
    }

    public void setColorCircle(Color colorCircle) {
        this.colorCircle = colorCircle;
    }

    public Boolean getHaveCircle() {
        return haveCircle;
    }

    public void setHaveCircle(Boolean haveCircle) {
        this.haveCircle = haveCircle;
    }
}
