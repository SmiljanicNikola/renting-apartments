package com.example.RentingApartments.model;

import javax.persistence.*;

@Entity
@Table(name="admins")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id", unique = true, nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User user;

    public Administrator(Integer id, User user) {
        this.id = id;
        this.user = user;
    }

    public Administrator() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
