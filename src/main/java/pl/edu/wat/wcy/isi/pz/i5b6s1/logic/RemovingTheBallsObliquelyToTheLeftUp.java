package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.MyRectangle;

import java.util.ArrayList;
/**
 * Klasa odpowiedzialna za usuwanie kulek po skosie \ <-- w tą stronę od przekątnej w górę
 */
public class RemovingTheBallsObliquelyToTheLeftUp implements RemovingBalls {
    @Override
    public boolean removingBalls(ArrayList<MyRectangle> listRectangle, ArrayList<Circle> listCircle, Pane pane, Label points, Color[] listColor) {
        boolean flag = false;
        RemovingTheBalls removingTheBalls = new RemovingTheBalls();
        Color[][] myCircleColorInRectangle = new Color[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                myCircleColorInRectangle[i][j] = listRectangle.get(i * 9 + j).getColorCircle();
            }
        }
        for (Color color : listColor) {
            int counter = 0;
            int index = 0;
            int endIndex = 0;
            Circle tempCircle = new Circle();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9 - i; j++) {
                    if (myCircleColorInRectangle[j][j + i].equals(color)) {
                        index++;
                        if (j == 8 - i) {
                            if (index >= 5) {
                                counter = index;
                                endIndex = (j + 1) * 10 + i;
                                flag=true;
                            }
                            index = 0;
                        }
                    } else {
                        if (index >= 5) {
                            counter = index;
                            endIndex = j * 10 + i;
                            flag=true;
                        }
                        index = 0;
                    }
                }
                if (counter != 0) {
                    for (int h = endIndex - counter * 10; h < endIndex; h = h + 10) {
                        removingTheBalls.removeCircle(h, listRectangle, listCircle, tempCircle, pane);
                    }
                    removingTheBalls.addPoints(points, counter);
                }
                counter = 0;
                index = 0;
                endIndex = 0;
            }
        }
        return flag;
    }
}
