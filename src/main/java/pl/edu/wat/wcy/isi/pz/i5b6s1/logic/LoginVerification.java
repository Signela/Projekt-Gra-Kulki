package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import pl.edu.wat.wcy.isi.pz.i5b6s1.database.CreateUser;
import pl.edu.wat.wcy.isi.pz.i5b6s1.database.model.User;


import java.util.List;
import java.util.logging.Logger;

/**
 * Klasa odpowiedzialna za wywołanie funkcji tworzącej użytkowników i zwracającej ich listy
 */
public class LoginVerification implements Runnable {
    public List<User> getListUsers() {
        return listUsers;
    }

    public static List<User> listUsers;

    public LoginVerification() {
    }

    @Override
    public void run() {
        CreateUser createUser = new CreateUser();
        listUsers = createUser.createUsers();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Logger.getGlobal().severe(e.getMessage());
        }

    }
}
