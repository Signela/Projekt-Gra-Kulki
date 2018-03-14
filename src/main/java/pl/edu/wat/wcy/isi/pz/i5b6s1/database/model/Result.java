package pl.edu.wat.wcy.isi.pz.i5b6s1.database.model;

import pl.edu.wat.wcy.isi.pz.i5b6s1.gui.App;

import javax.persistence.*;
import java.io.Serializable;

/**
 * klasa, która ma swoje odzwierciedlenie w bazie danych, przedstawia encję z wynikami gracza
 */
@Entity
@Table(name = "Result")
public class Result implements Serializable {

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "Login")
    private String login;
    @Column(name = "NUMBEROFPOINTS")
    private int numberOfPoints;

    public User getUser() {
        return user;
    }

    public void setUser(User person) {
        this.user = person;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public Result(int numberOfPoints, User user) {
        login = App.actualLogin;
        this.numberOfPoints = numberOfPoints;
        this.user = user;
    }
}
