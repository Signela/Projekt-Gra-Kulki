package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.IsInternet;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.LanguageFile;

import java.util.Objects;

/**
 * Klasa odpowiedzialna za budowę menu programu
 */
public class MenuContainer {
    private Stage primaryStage;
    private Scene sceneInfo, sceneGame, sceneMenu;
    private StackPane stackPane;

    public MenuContainer(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public StackPane createContainer() {
        stackPane = new StackPane();
        MyImage myImage = new MyImage();
        Label image = myImage.addImage(App.myBacground);
        stackPane.getChildren().add(image);
        addButtons();
        IsInternet isInternet = new IsInternet();
        Boolean flag = isInternet.isInernet();
        String path;
        Image myImages;
        ImageView imageView;
        if (flag) {
            path = App.properties.getProperty("obrazeczek");
            myImages = new Image(path);
            imageView = new ImageView(myImages);
        } else {
            path = App.properties.getProperty("gif");
            myImages = new Image(path);
            imageView = new ImageView(myImages);
        }
        imageView.setTranslateX(-150);
        stackPane.getChildren().add(imageView);
        return stackPane;
    }

    private void addButtons() {
        Button buttonStart = new MyButton(App.languageFile[11], App.languageFile[12], App.myButtonColor).createButton();
        buttonStart.setTranslateY(-50);
        stackPane.getChildren().add(buttonStart);

        buttonStart.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                LogContainer logContainer = new LogContainer(primaryStage);
                sceneGame = new Scene(logContainer.createContent(), 270, 350);
                primaryStage.setScene(sceneGame);
                primaryStage.setTitle(App.languageFile[13]);
                primaryStage.centerOnScreen();
            }
        });
        Button load = new MyButton(App.languageFile[14], App.languageFile[15], App.myButtonColor).createButton();
        stackPane.getChildren().add(load);
        load.setOnAction((ActionEvent event) -> {
            if (Objects.equals(App.myBacground, App.properties.getProperty("kulka"))) {
                App.myBacground = App.properties.getProperty("ku");
                App.myButtonColor = App.properties.getProperty("kolor2");
            } else if (Objects.equals(App.myBacground, App.properties.getProperty("ku"))) {
                App.myBacground = App.properties.getProperty("tlo");
                App.myButtonColor = App.properties.getProperty("kolor3");
            } else {
                App.myBacground = App.properties.getProperty("kulka");
                App.myButtonColor = App.properties.getProperty("kolor1");
            }
            primaryStage.close();
            MenuContainer menuContainer2 = new MenuContainer(primaryStage);
            sceneMenu = new Scene(menuContainer2.createContainer(), 485, 384);
            primaryStage.setScene(sceneMenu);
            primaryStage.setResizable(false);
            primaryStage.setTitle(App.languageFile[28]);
            primaryStage.show();
        });
        Button exit = new MyButton(App.languageFile[16], App.languageFile[17], App.myButtonColor).createButton();
        exit.setTranslateY(100);
        exit.setOnAction((ActionEvent event) -> {
            System.exit(1);
        });
        stackPane.getChildren().add(exit);
        Button author = new MyButton(App.languageFile[18], App.languageFile[19], App.myButtonColor).createButton();
        author.setTranslateY(150);
        stackPane.getChildren().add(author);
        author.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                AuthorContainer authorContainer = new AuthorContainer(primaryStage);
                sceneInfo = new Scene(authorContainer.createContent(), 485, 335);
                primaryStage.setScene(sceneInfo);
                primaryStage.setTitle(App.languageFile[18]);
                primaryStage.show();
            }
        });
        Label title = new Label(App.languageFile[20]);
        title.setTranslateY(-120);
        title.setFont(Font.font(80));
        stackPane.getChildren().add(title);
        Button language = new MyButton(App.languageFile[21], App.languageFile[22], App.myButtonColor).createButton();
        language.setTranslateY(50);
        stackPane.getChildren().add(language);
        language.setOnAction((ActionEvent event) -> {
            LanguageFile languageFile = new LanguageFile();
            if (App.myLanguage.equals(App.properties.getProperty("pol"))) {
                App.myLanguage = App.properties.getProperty("ang");
            } else {
                App.myLanguage = App.properties.getProperty("pol");
            }
            App.languageFile = languageFile.languageFile(App.myLanguage);
            ButtonReturn buttonReturn = new ButtonReturn();
            buttonReturn.handle(event, primaryStage);
        });

    }
}
