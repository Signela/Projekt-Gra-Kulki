package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Klasa odpowiedzialna za budowę ekranu z informacjami o autorze
 */
public class AuthorContainer {

    private Pane pane;
    private Stage primaryStage;

    public AuthorContainer(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addLabel() {
        Label title = new Label(App.languageFile[0]);
        title.setTranslateX(50);
        title.setFont(Font.font(63));
        title.blendModeProperty().set(BlendMode.GREEN);
        pane.getChildren().add(title);
        Label titleAuthor = new Label(App.languageFile[30]);
        titleAuthor.setTranslateY(80);
        titleAuthor.setTranslateX(60);
        titleAuthor.setFont(Font.font(50));
        titleAuthor.blendModeProperty().set(BlendMode.GREEN);
        pane.getChildren().add(titleAuthor);
        Label titleGroup = new Label(App.languageFile[31]);
        titleGroup.setTranslateY(150);
        titleGroup.setTranslateX(170);
        titleGroup.setFont(Font.font(40));
        titleGroup.blendModeProperty().set(BlendMode.GREEN);
        pane.getChildren().add(titleGroup);
    }

    public void addButton() {
        Button buttonReturn = new MyButton(App.languageFile[1], App.languageFile[2], App.myButtonColor).createButton();
        buttonReturn.setTranslateY(250);
        pane.getChildren().add(buttonReturn);

        ButtonReturn buttonR = new ButtonReturn();
        buttonReturn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                buttonR.handle(event, primaryStage);
            }
        });
    }

    public Pane createContent() {
        pane = new Pane();
        MyImage myImage = new MyImage();
        Label labelStart = myImage.addImage(App.properties.getProperty("autor"));
        pane.getChildren().add(labelStart);
        addLabel();
        addButton();
        return pane;
    }
}
