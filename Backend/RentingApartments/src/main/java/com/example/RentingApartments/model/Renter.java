package com.example.RentingApartments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="renters")
public class Renter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="renter_id", unique = true, nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name="phone_number", unique=false, nullable=false)
    private String phoneNumber;

    @Column(name="email", unique=false, nullable=false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy="renter")
    private List<Advertisement> advertisements;

    @JsonIgnore
    @OneToMany(mappedBy="owner")
    private List<Apartment> apartments;

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Renter() {
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

    public Renter(Integer id, User user, String phoneNumber, String email, List<Advertisement> advertisements, List<Apartment> apartments) {
        this.id = id;
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.advertisements = advertisements;
        this.apartments = apartments;
    }

    public Renter(User user, String phoneNumber, String email) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Renter(Integer id, User user, String phoneNumber, String email) {
        this.id = id;
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
