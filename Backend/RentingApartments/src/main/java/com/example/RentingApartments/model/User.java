package com.example.RentingApartments.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", unique = true, nullable = false)
    private Integer id;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    @Column(name="lastname", unique=false, nullable=false)
    private String lastname;

    @Column(name="username", unique=false, nullable=false)
    private String username;

    @Column(name="password", unique=false, nullable=false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    public User() {
    }

    public User(String name, String lastname, String username, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String name, String lastname, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public User(String name, String lastname, String username, String password, Roles role) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Roles getRole() {
        return role;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
