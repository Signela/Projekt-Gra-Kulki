package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.MyRectangle;

import java.util.ArrayList;

/**
 * Klasa odpowiedzialna za usuwanie kulek po skosie / <-- w tą stronę od przekątnej w górę
 */
public class RemovingTheBallsObliquelyToTheRightUp implements RemovingBalls {
    @Override
    public boolean removingBalls(ArrayList<MyRectangle> listRectangle, ArrayList<Circle> listCircle, Pane pane, Label points, Color[] listColor) {
        boolean flag = false;
        RemovingTheBalls removingTheBalls = new RemovingTheBalls();
        Color[][] myCircleColorInRectangle = new Color[9][9];
        int[][] mylistidRectangle = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                myCircleColorInRectangle[8 - i][j] = listRectangle.get(i * 9 + j).getColorCircle();
                mylistidRectangle[8 - i][j] = listRectangle.get(i * 9 + j).getId();
            }
        }
        for (Color color : listColor) {
            int counter = 0;
            int index = 0;
            int temp = 0;
            int endIndex = 0;
            Circle tempCircle = new Circle();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9 - i; j++) {
                    if (myCircleColorInRectangle[j + i][j].equals(color)) {
                        index++;
                        if (index == 1) {
                            temp = mylistidRectangle[j + i][j] + 10;
                        }
                        if (j == 8 - i) {
                            if (index >= 5) {
                                counter = index;
                                endIndex = temp;
                                temp = 0;
                                flag = true;
                            }
                            index = 0;
                        }
                    } else {

                        if (index >= 5) {
                            counter = index;
                            endIndex = temp;
                            flag = true;
                        }
                        index = 0;
                        temp = 0;
                    }
                }
                if (counter != 0) {
                    for (int h = endIndex - (counter - 1) * 8 - 10; h < endIndex - 2; h = h + 8) {
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
