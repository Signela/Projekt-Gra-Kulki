package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * klasa w której tworze ekran startowy (meni), jest ona potrzebna do przyłączenia do guzika
 * akcji powrotu do menu
 */
public class ButtonReturn {
    public void handle(ActionEvent event, Stage primaryStage) {
        MenuContainer menuContainer = new MenuContainer(primaryStage);
        Scene sceneMenu = new Scene(menuContainer.createContainer(), 485, 384);
        primaryStage.setScene(sceneMenu);
        primaryStage.setTitle(App.languageFile[28]);
        primaryStage.centerOnScreen();
    }
}
