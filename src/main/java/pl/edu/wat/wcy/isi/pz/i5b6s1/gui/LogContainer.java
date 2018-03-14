package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pl.edu.wat.wcy.isi.pz.i5b6s1.database.model.User;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.TheListOfUsersIsEmpty;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.TheUserDoesNotExist;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.WrongPassword;
import java.util.List;

/**
 * Klasa odpowiedzialna za zbudowanie ekranu logowania do gry, weryfikuję również poprawność danych logowania
 */
public class LogContainer {
    private GridPane gridPane;
    private Stage primaryStage;
    public LogContainer(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addItems(){

        Label label = new Label(App.languageFile[5]);
        label.setFont(Font.font(40));
        label.setTranslateY(-120);
        label.setTranslateX(30);
        gridPane.getChildren().add(label);
        TextField textField = new TextField();
        textField.setText(App.languageFile[6]);
        textField.setTranslateY(-70);
        textField.setTranslateX(60);
        textField.setMaxSize(150,20);
        gridPane.getChildren().add(textField);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(App.languageFile[7]);
        passwordField.setTranslateY(-40);
        passwordField.setTranslateX(60);
        passwordField.setMaxSize(150,20);
        gridPane.getChildren().add(passwordField);

        Button buttonReturn= new MyButton(App.languageFile[1], App.languageFile[2], App.myButtonColor).createButton();
        buttonReturn.setTranslateY(100);
        buttonReturn.setTranslateX(20);
        gridPane.getChildren().add(buttonReturn);

        ButtonReturn buttonR = new ButtonReturn();
        buttonReturn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                buttonR.handle(event,primaryStage);
            }
        });
        Button ok = new MyButton(App.languageFile[29],App.languageFile[5],App.myButtonColor).createButton();
        ok.setTranslateY(100);
        ok.setTranslateX(180);
        ok.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                List<User> listUsers = App.log.getListUsers();
                boolean flag=false;
                if(listUsers!=null){
                for (User user: listUsers) {
                    if(user.getLogin().equals(textField.getText())){
                        flag=true;
                        if(user.getPassword().equals(passwordField.getText())){
                            App.actualLogin = user.getLogin();
                            GameContainer gameContainer = new GameContainer(primaryStage);
                            Scene sceneGame = new Scene(gameContainer.createContent(),500, 500);
                            primaryStage.setScene(sceneGame);
                            primaryStage.setTitle(App.languageFile[8]);
                            primaryStage.centerOnScreen();

                        }
                        else{
                            try {
                                throw new WrongPassword(label);
                            } catch (WrongPassword wrongPassword) {
                            }
                        }
                    } else if(!flag){
                        try {
                            throw new TheUserDoesNotExist(label);
                        } catch (TheUserDoesNotExist theUserDoesNotExist) {
                        }
                    }
                }
            }else{
                    try {
                        throw new TheListOfUsersIsEmpty(label);
                    } catch (TheListOfUsersIsEmpty theListOfUsersIsEmpty) {
                    }
                }}
        });
        gridPane.getChildren().add(ok);
    }
    public GridPane createContent() {
        gridPane = new GridPane();
        MyImage myImage = new MyImage();
        Label labelStart = myImage.addImage(App.properties.getProperty("login"));
        gridPane.getChildren().add(labelStart);
        addItems();
        return gridPane;
    }
}

