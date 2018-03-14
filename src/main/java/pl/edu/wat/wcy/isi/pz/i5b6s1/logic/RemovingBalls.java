package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.MyRectangle;

import java.util.ArrayList;

/**
 * interfejs odpowiedzialny za wymuszenie na klasie zrealizowania metody usuwania kulek
 */
public interface RemovingBalls {
    boolean removingBalls(ArrayList<MyRectangle> listRectangle, ArrayList<Circle> listCircle, Pane pane, Label points, Color[] listColor);
}
