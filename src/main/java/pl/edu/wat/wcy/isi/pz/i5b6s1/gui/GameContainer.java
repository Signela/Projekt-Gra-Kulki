package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.EndGame;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.MauseClickOnRectangleOrCircle;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.StartGame;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.GoodMovement;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.ImpossibleMovement;

import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa odpowiedzialna za budowę ekranu gry
 */
public class GameContainer {
    private Random random = new Random();
    private Pane pane;
    private Scene sceneResults;
    private Stage primaryStage;
    private ArrayList<MyRectangle> listRectangle = new ArrayList<>();
    public static Label points = new Label();
    public static Label statement = new Label();
    private Color[] listColor = {Color.RED, Color.GREEN, Color.BLACK, Color.GREY, Color.MAGENTA, Color.MOCCASIN, Color.CYAN};
    MauseClickOnRectangleOrCircle mauseClickOnRectangleOrCircle = new MauseClickOnRectangleOrCircle();
    MyImage myImage = new MyImage();
    private ArrayList<Circle> smallListCircle = new ArrayList<>();
    private ArrayList<Circle> listCircle = new ArrayList<>();
    private boolean flag = false;
    private Stage newStage = new Stage();

    public void addStatement() {
        statement.setText(App.languageFile[23]);
        statement.setTranslateX(360);
        statement.setTranslateY(20);
        statement.setFont(Font.font(25));
        pane.getChildren().add(statement);
    }

    public void addSmallListCircle() {
        for (int i = 0; i < 3; i++) {
            Circle circle = new Circle(15, Color.RED);
            circle.setTranslateX(210 + i * 35);
            circle.setTranslateY(37);
            smallListCircle.add(circle);
            pane.getChildren().add(circle);
        }
    }

    public void addPoints() {
        points.setText("0");
        points.setTranslateX(310);
        points.setTranslateY(20);
        points.setFont(Font.font(25));
        pane.getChildren().add(points);
    }

    public void addRectangle() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                MyRectangle myRectangle = new MyRectangle();
                Rectangle rectangle = new Rectangle(40, 40, Color.BLUE);
                rectangle.setX(100 + j * 41);
                rectangle.setY(80 + i * 41);
                myRectangle.setRectangle(rectangle);
                myRectangle.setColorCircle(Color.WHITE);
                myRectangle.setHaveCircle(false);
                myRectangle.setId(i * 9 + j);
                mauseClickOnRectangleOrCircle.mauseClickOnRectangle(myRectangle, listCircle, listRectangle, listColor, smallListCircle, pane, points, statement);
                listRectangle.add(myRectangle);
                pane.getChildren().add(myRectangle.getRectangle());
            }
        }
    }

    public void addButton() {
        Button buttonReturn = new MyButton(App.languageFile[28], App.languageFile[2], App.myButtonColor).createButton();
        buttonReturn.setTranslateY(20);
        buttonReturn.setTranslateX(20);
        pane.getChildren().add(buttonReturn);
        ButtonReturn buttonR = new ButtonReturn();
        buttonReturn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                buttonR.handle(event, primaryStage);
            }
        });
        Button start = new MyButton(App.languageFile[3], App.languageFile[4], App.myButtonColor).createButton();
        start.setTranslateX(120);
        start.setTranslateY(20);
        pane.getChildren().add(start);
        StartGame startGame = new StartGame();
        startGame.startGame(start, pane, listCircle, random, listRectangle, listColor, smallListCircle, mauseClickOnRectangleOrCircle, points, statement, newStage);
    }

    public GameContainer(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Pane createContent() {
        pane = new Pane();
        Label labelStart = myImage.addImage(App.properties.getProperty("serduszka"));
        pane.getChildren().add(labelStart);
        addRectangle();
        addSmallListCircle();
        addPoints();
        addStatement();
        addButton();
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                try {
                    int x = 0;
                    for (MyRectangle rectangle : listRectangle) {
                        if (rectangle.getHaveCircle()) {
                            x++;
                        }
                    }
                    if (x == listRectangle.size()) {
                        if (!flag) {
                            statement.setText(App.languageFile[27]);
                            flag = true;

                            ResultsContainer resultsContainer = new ResultsContainer(newStage);
                            sceneResults = new Scene(resultsContainer.createContent(), 300, 350);
                            newStage.setScene(sceneResults);
                            newStage.show();
                            EndGame endGame = new EndGame();
                            Thread thread = new Thread(endGame);
                            thread.start();
                        }
                    } else if (t.getX() < 100 || t.getY() < 80 || t.getY() > 450 || t.getX() > 470) {
                        flag = false;
                        throw new ImpossibleMovement(statement);
                    } else {
                        flag = false;
                        throw new GoodMovement(statement);
                    }
                } catch (ImpossibleMovement | GoodMovement e) {
                }
            }
        });

        return pane;
    }
}
