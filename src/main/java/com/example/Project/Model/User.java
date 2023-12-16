package com.example.Project.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int idUser;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="infos")
    private String infos;

    @OneToMany(mappedBy = "theUser", cascade = CascadeType.ALL)
    private Set<Recipe> recipes = new HashSet<>();
    @OneToMany(mappedBy = "theUser", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
    @OneToMany(mappedBy = "theUser", cascade = CascadeType.ALL)
    private Set<Favorite> favorites = new HashSet<>();

    public User() {
    }
    public User(int idUser, String name, String email, String password, String infos) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.infos = infos;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", infos='" + infos + '\'' +
                '}';
    }
}
