package pl.edu.wat.wcy.isi.pz.i5b6s1.database.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa mająca swoje dzwierciedlenie w bazie danych, jest to encja tworząca użytkownika, który ma
 * swój własny login i hasło
 */
@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    private String login;
    @Column(name = "Password")
    private String password;

    public List<Result> getResults() {
        if (results == null) {
            results = new LinkedList<>();
        }
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "login")
    @Fetch(FetchMode.SELECT)
    private List<Result> results;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String surname) {
        this.login = name;
        this.password = surname;
    }

    public User() {
    }
}



