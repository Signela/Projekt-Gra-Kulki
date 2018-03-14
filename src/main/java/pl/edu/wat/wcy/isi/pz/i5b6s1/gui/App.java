package pl.edu.wat.wcy.isi.pz.i5b6s1.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.*;

import java.util.Properties;

/**
 * Klasa inicjująca działanie aplikajci, zwiera w sobie zmienne globalne, jak również metode w której
 * inicjowane jest stworzenie meni
 */
public class App extends Application {
    public static Properties properties = new Properties();
    public static String[] languageFile;
    public static String myLanguage = "angielski";
    public static LoginVerification log = new LoginVerification();
    public static String myButtonColor = "#800000";
    public static Thread database = new Thread(log);
    public static String myBacground = "file:tlo.jpg";
    public static String actualLogin;
    public static String resoltGame = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuContainer menuContainer = new MenuContainer(primaryStage);
        Scene scene = new Scene(menuContainer.createContainer(), 485, 384);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(languageFile[28]);
        primaryStage.show();
    }

    public static void main(String[] args) {
        MyLogger myLogger = new MyLogger();
        myLogger.myLogger();
        ReadProperties properties = new ReadProperties();
        LanguageFile languageFile1 = new LanguageFile();
        Thread prop = new Thread(properties);
        Thread language = new Thread(languageFile1);
        database.start();
        prop.start();
        language.start();
        Application.launch(args);
    }
}
