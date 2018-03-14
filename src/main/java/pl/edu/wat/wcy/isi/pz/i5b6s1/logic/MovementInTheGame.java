package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.MyRectangle;


import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa odpowiedzialna za ruch kulki na planszy (przeniesienie jej z jednego miejsca na drugie)
 */
public class MovementInTheGame {
    public void movementInTheGame(MyRectangle beforeTheMovement, MyRectangle afterTheMovement, ArrayList<Circle> listCircle, Color[] listColor, ArrayList<MyRectangle> listRectangle, ArrayList<Circle> smallListCircle, Pane pane, Label points, Label statement) {
        Random random = new Random();
        MauseClickOnRectangleOrCircle mauseClickOnRectangleOrCircle = new MauseClickOnRectangleOrCircle();
        beforeTheMovement.getRectangle().setFill(Color.BLUE);
        listRectangle.set(beforeTheMovement.getId(), beforeTheMovement);
        int i = 0;
        int number = -10;
        for (Circle circle : listCircle) {
            if (circle.getTranslateY() - 20 == beforeTheMovement.getRectangle().getY() && circle.getTranslateX() - 20 == beforeTheMovement.getRectangle().getX()) {
                number = i;
            }
            i++;
        }
        if (number != -10) {
            pane.getChildren().remove(listCircle.get(number));
            Circle circle = listCircle.get(number);
            listCircle.remove(circle);
            circle.setTranslateX(afterTheMovement.getRectangle().getX() + 20);
            circle.setTranslateY(afterTheMovement.getRectangle().getY() + 20);
            mauseClickOnRectangleOrCircle.mauseClickOnCircle(afterTheMovement, listCircle, listRectangle, listColor, smallListCircle, pane, circle, points, statement);
            afterTheMovement.setColorCircle((Color) circle.getFill());
            afterTheMovement.setHaveCircle(true);
            beforeTheMovement.setHaveCircle(false);
            beforeTheMovement.setColorCircle(Color.WHITE);
            listRectangle.set(afterTheMovement.getId(), afterTheMovement);
            listRectangle.set(beforeTheMovement.getId(), beforeTheMovement);
            pane.getChildren().add(circle);
            listCircle.add(circle);
        }
        RemovingTheBalls removingTheBalls = new RemovingTheBalls();

        if (!removingTheBalls.removeBalls(listRectangle, listCircle, pane, points, listColor)) {
            if (listCircle.size() < 79) {
                addNewSmallBall(smallListCircle, random, listRectangle, listCircle, listColor, pane, points, mauseClickOnRectangleOrCircle, 0, statement);
                addNewSmallBall(smallListCircle, random, listRectangle, listCircle, listColor, pane, points, mauseClickOnRectangleOrCircle, 1, statement);
                addNewSmallBall(smallListCircle, random, listRectangle, listCircle, listColor, pane, points, mauseClickOnRectangleOrCircle, 2, statement);
            } else if (listCircle.size() == 80) {
                addNewSmallBall(smallListCircle, random, listRectangle, listCircle, listColor, pane, points, mauseClickOnRectangleOrCircle, 0, statement);
            } else if (listCircle.size() == 79) {

                addNewSmallBall(smallListCircle, random, listRectangle, listCircle, listColor, pane, points, mauseClickOnRectangleOrCircle, 0, statement);
                addNewSmallBall(smallListCircle, random, listRectangle, listCircle, listColor, pane, points, mauseClickOnRectangleOrCircle, 1, statement);
            }
            removingTheBalls.removeBalls(listRectangle, listCircle, pane, points, listColor);
        }
    }

    public int findAPlace(Random random, ArrayList<MyRectangle> listRectangle, ArrayList<Circle> listCircle) {
        boolean flag = false;
        int nr = random.nextInt(listRectangle.size());

        for (Circle temp : listCircle) {
            if (listRectangle.get(nr).getRectangle().getX() + 20 == temp.getTranslateX() && listRectangle.get(nr).getRectangle().getY() + 20 == temp.getTranslateY()) {
                flag = true;
            }
        }
        while (flag) {
            flag = false;
            nr = random.nextInt(listRectangle.size());
            for (Circle temp : listCircle) {
                if (listRectangle.get(nr).getRectangle().getX() == temp.getTranslateX() - 20 && listRectangle.get(nr).getRectangle().getY() == temp.getTranslateY() - 20) {
                    flag = true;
                }
            }
        }
        return nr;
    }

    public void addNewSmallBall(ArrayList<Circle> smallListCircle, Random random, ArrayList<MyRectangle> listRectangle, ArrayList<Circle> listCircle, Color[] listColor, Pane pane, Label points, MauseClickOnRectangleOrCircle mauseClickOnRectangleOrCircle, int i, Label statement) {
        Circle newCircle = new Circle(20, smallListCircle.get(i).getFill());
        int nr = findAPlace(random, listRectangle, listCircle);
        newCircle.setTranslateX(listRectangle.get(nr).getRectangle().getX() + 20);
        newCircle.setTranslateY(listRectangle.get(nr).getRectangle().getY() + 20);
        listRectangle.get(nr).setHaveCircle(true);
        listRectangle.get(nr).setColorCircle((Color) newCircle.getFill());
        listCircle.add(newCircle);
        mauseClickOnRectangleOrCircle.mauseClickOnCircle(listRectangle.get(nr), listCircle, listRectangle, listColor, smallListCircle, pane, newCircle, points, statement);
        pane.getChildren().add(newCircle);
        smallListCircle.get(i).setFill(listColor[random.nextInt(listColor.length)]);
    }
}


