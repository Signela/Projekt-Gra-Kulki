package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Klasa odpowiedzialana za załadowanie odpowiedniego pliku w zależniości od wersji językowej gry
 */
public class LanguageFile implements Runnable {
    public String[] languageFile(String myLanguage) {
        String[] buffor = new String[100];
        BufferedReader in;
        try {
            if (myLanguage.equals(App.properties.getProperty("pol"))) {
                in = new BufferedReader(
                        new FileReader("slownikP.xml"));
            } else {
                in = new BufferedReader(
                        new FileReader("slownikA.xml"));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            in.close();
            String text = sb.toString();
            buffor = text.split("\n");
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
        return buffor;
    }

    @Override
    public void run() {
        App.languageFile = languageFile(App.myLanguage.toString());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
    }
}
