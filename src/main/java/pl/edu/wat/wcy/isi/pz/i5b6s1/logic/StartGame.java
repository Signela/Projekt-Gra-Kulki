package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.MyRectangle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa odpowiedzialna za zainicjowanie gry
 */
public class StartGame {
    public void startGame(Button start, Pane pane, ArrayList<Circle> listCircle, Random random, ArrayList<MyRectangle> listRectangle, Color[] listColor, ArrayList<Circle> smallListCircle, MauseClickOnRectangleOrCircle mauseClickOnRectangleOrCircle, Label points, Label statement, Stage newStage) {

        start.setOnAction((ActionEvent event) -> {
            newStage.close();
            points.setText("0");
            statement.setText(App.languageFile[23]);
            for (Circle circle : listCircle) {
                pane.getChildren().remove(circle);
            }
            listCircle.removeAll(listCircle);
            for (MyRectangle rec : listRectangle) {
                rec.getRectangle().setFill(Color.BLUE);
                rec.setHaveCircle(false);
                rec.setColorCircle(Color.WHITE);
            }
            MovementInTheGame movementInTheGame = new MovementInTheGame();
            for (int i = 0; i < 5; i++) {
                int nr = movementInTheGame.findAPlace(random, listRectangle, listCircle);
                Circle circle = new Circle(20, listColor[random.nextInt(listColor.length)]);
                circle.setTranslateX(listRectangle.get(nr).getRectangle().getX() + 20);
                circle.setTranslateY(listRectangle.get(nr).getRectangle().getY() + 20);
                listRectangle.get(nr).setColorCircle((Color) circle.getFill());
                listRectangle.get(nr).setHaveCircle(true);
                listCircle.add(circle);
                for (Circle smallCircle : smallListCircle) {
                    smallCircle.setFill(listColor[random.nextInt(listColor.length)]);
                }
                mauseClickOnRectangleOrCircle.mauseClickOnCircle(listRectangle.get(nr), listCircle, listRectangle, listColor, smallListCircle, pane, circle, points, statement);
                pane.getChildren().add(circle);
            }
        });
    }
}
