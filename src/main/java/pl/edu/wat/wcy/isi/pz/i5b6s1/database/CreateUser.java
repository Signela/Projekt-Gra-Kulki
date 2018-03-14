package pl.edu.wat.wcy.isi.pz.i5b6s1.database;

import pl.edu.wat.wcy.isi.pz.i5b6s1.database.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * klasa inicjująca postanie graczy, jak również wygenerowanie listy wszystkich użytkowników
 */
public class CreateUser {
    public List<User> createUsers() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PZ");
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new User("log", "log"));
            em.persist(new User("user2", "user2"));
            em.persist(new User("patycia", "patycia"));
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        List<User> userList = em.createQuery("SELECT p FROM User p", User.class).getResultList();
        em.close();
        factory.close();
        return userList;
    }
}
