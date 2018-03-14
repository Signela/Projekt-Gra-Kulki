package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.MyRectangle;

import java.util.ArrayList;

/**
 * Klasa odpowiedzialna za wywoływanie funkcji do usuwania kulek, jak również fizycznie usuwanie kulek
 * z ekranu oraz naliczaniu odpowiedniej ilości punktów
 */
public class RemovingTheBalls {
    public boolean removeBalls(ArrayList<MyRectangle> listRectangle, ArrayList<Circle> listCircle, Pane pane, Label points, Color[] listColor) {
        boolean flag = false;
        RemovingTheBallsHorizontally removingTheBallsHorizontally = new RemovingTheBallsHorizontally();
        RemovingTheBallsObliquelyToTheLeftDown removingTheBallsObliquelyToTheLeftDown = new RemovingTheBallsObliquelyToTheLeftDown();
        RemovingTheBallsObliquelyToTheLeftUp removingTheBallsObliquelyToTheLeftUp = new RemovingTheBallsObliquelyToTheLeftUp();
        RemovingTheBallsObliquelyToTheRightDown removingTheBallsObliquelyToTheRightDown = new RemovingTheBallsObliquelyToTheRightDown();
        RemovingTheBallsObliquelyToTheRightUp removingTheBallsObliquelyToTheRightUp = new RemovingTheBallsObliquelyToTheRightUp();
        RemovingTheBallsPerpendicularly removingTheBallsPerpendicularly = new RemovingTheBallsPerpendicularly();
        if (removingTheBallsHorizontally.removingBalls(listRectangle, listCircle, pane, points, listColor) ||
                removingTheBallsPerpendicularly.removingBalls(listRectangle, listCircle, pane, points, listColor) ||
                removingTheBallsObliquelyToTheLeftDown.removingBalls(listRectangle, listCircle, pane, points, listColor) ||
                removingTheBallsObliquelyToTheLeftUp.removingBalls(listRectangle, listCircle, pane, points, listColor) ||
                removingTheBallsObliquelyToTheRightDown.removingBalls(listRectangle, listCircle, pane, points, listColor) ||
                removingTheBallsObliquelyToTheRightUp.removingBalls(listRectangle, listCircle, pane, points, listColor)) {
            flag = true;
        }
        return flag;
    }

    public void removeCircle(int h, ArrayList<MyRectangle> listRectangle, ArrayList<Circle> listCircle, Circle tempCircle, Pane pane) {
        try {
            listRectangle.get(h).setColorCircle(Color.WHITE);
            listRectangle.get(h).setHaveCircle(false);
            for (Circle circle : listCircle) {
                if (circle.getTranslateX() - 20 == listRectangle.get(h).getRectangle().getX() && circle.getTranslateY() - 20 == listRectangle.get(h).getRectangle().getY()) {
                    tempCircle = circle;
                }
            }
            listCircle.remove(tempCircle);
            pane.getChildren().remove(tempCircle);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public void addPoints(Label points, int counter) {
        String point = points.getText();
        Integer p = Integer.parseInt(point);
        p = p + counter;
        points.setText(p.toString());
    }
}
