package pl.edu.wat.wcy.isi.pz.i5b6s1.database;

import pl.edu.wat.wcy.isi.pz.i5b6s1.database.model.Result;
import pl.edu.wat.wcy.isi.pz.i5b6s1.database.model.User;
import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;
import pl.edu.wat.wcy.isi.pz.i5b6s1.logic.LoginVerification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * klasa odpowiedzialna za zapis ostatniego wyniku użytkownika, jak również wygenerowanie
 * listy wszystkich dotychczasowych wyników użytkowników
 */
public class SaveResoult {
    public String saveResoult(int numberOfPoints) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PZ");
        EntityManager em = factory.createEntityManager();
        LoginVerification loginVerification = new LoginVerification();
        User user = null;
        for (User u : LoginVerification.listUsers) {
            if (u.getLogin().equals(App.actualLogin)) {
                user = u;
            }
        }

        try {
            em.getTransaction().begin();
            em.persist(new Result(numberOfPoints, user));
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        List<Result> resultsList = em.createQuery("SELECT p FROM Result p", Result.class).getResultList();
        String myResult = "";
        for (Result result : resultsList) {
            myResult = myResult + result.getId() + " " + result.getLogin() + " " + result.getNumberOfPoints() + "\n";
        }
        em.close();
        factory.close();
        return myResult;
    }
}
