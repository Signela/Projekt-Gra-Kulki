package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.NotFoundMyProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * Klasa odpowiedzialana za odczyt danych zapisanych w pliku config.properties
 */
public class ReadProperties implements Runnable {
    InputStream inputStream;

    public void readPropertiesValues() throws IOException {

        try {
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                App.properties.load(inputStream);
            } else {
                throw new NotFoundMyProperties("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (NotFoundMyProperties e) {
            Logger.getGlobal().severe(e.getMessage());
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
    }

    @Override
    public void run() {
        try {
            readPropertiesValues();
            Thread.sleep(100);
        } catch (IOException | InterruptedException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
    }
}
