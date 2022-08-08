package com.example.RentingApartments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id", unique = true, nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name="phone_number", unique=false, nullable=false)
    private String phoneNumber;

    @Column(name="email", unique=false, nullable=false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy="reviewAuthor")
    private List<Review> reviews;

    @JsonIgnore
    @OneToMany(mappedBy="client")
    private List<RentRequest> rentRequests;

    public Client() {
    }

    public Client(Integer id, User user, String phoneNumber, String email) {
        this.id = id;
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Client(User user, String phoneNumber, String email) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<RentRequest> getRentRequests() {
        return rentRequests;
    }

    public void setRentRequests(List<RentRequest> rentRequests) {
        this.rentRequests = rentRequests;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
