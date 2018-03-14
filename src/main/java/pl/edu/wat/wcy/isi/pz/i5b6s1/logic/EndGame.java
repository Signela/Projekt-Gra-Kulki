package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import pl.edu.wat.wcy.isi.pz.i5b6s1.database.SaveResoult;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.GameContainer;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.ResultsContainer;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.exceptions.TheListResultsNotExist;

/**
 * Klasa odpowiedzialna za wywołanie funkcji związanych z zapisem wyniku użytkownika jak również
 * przedstawienie wyników na ekranie
 */
public class EndGame implements Runnable {
    public void endGame(int numberOfPoints) {
        SaveResoult saveResoult = new SaveResoult();
        App.resoltGame = saveResoult.saveResoult((numberOfPoints));
        while (App.resoltGame.equals("")) {
            try {
                throw new TheListResultsNotExist(ResultsContainer.textArea);
            } catch (TheListResultsNotExist e) {
            }
        }
        ResultsContainer.textArea.setText(App.resoltGame);
        App.resoltGame = "";
    }

    @Override
    public void run() {
        endGame(Integer.parseInt(GameContainer.points.getText()));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
