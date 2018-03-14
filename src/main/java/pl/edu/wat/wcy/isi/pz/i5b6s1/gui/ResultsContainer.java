package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Klasa odpowiedzialna za zbudowanie ekranu z wynikami użytkowników
 */
public class ResultsContainer {
    private GridPane gridPane;
    public static TextArea textArea = new TextArea();
    private Stage primaryStage;

    public ResultsContainer(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addItems() {
        Label label = new Label(App.languageFile[33]);
        label.setFont(Font.font(40));
        label.setTranslateX(50);
        label.setTranslateY(-50);
        gridPane.getChildren().add(label);

        textArea.setTranslateY(100);
        textArea.setTranslateX(50);
        textArea.setMaxSize(200, 200);
        textArea.setText(App.resoltGame);
        gridPane.getChildren().add(textArea);
    }

    public GridPane createContent() {
        gridPane = new GridPane();
        gridPane.getChildren();
        addItems();
        return gridPane;
    }
}
