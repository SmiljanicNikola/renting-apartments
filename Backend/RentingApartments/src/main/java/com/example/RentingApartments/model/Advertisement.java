package com.example.RentingApartments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="advertisements")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="advertisement_id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="renter_id", referencedColumnName = "renter_id")
    private Renter renter;

    @ManyToOne
    @JoinColumn(name="apartment_id", referencedColumnName = "apartment_id")
    private Apartment apartment;

    @Column(name="price", unique=false, nullable=false)
    private float price;

    @Column(name="expired", unique=false, nullable=false)
    private boolean expired;

    @Column(name="valid", unique=false, nullable=false)
    private boolean valid;

    @JsonIgnore
    @OneToMany(mappedBy="advertisement")
    private List<RentRequest> rentRequests;

    public Advertisement(Integer id, Renter renter, Apartment apartment, float price, boolean expired, boolean valid) {
        this.id = id;
        this.renter = renter;
        this.apartment = apartment;
        this.price = price;
        this.expired = expired;
        this.valid = valid;
    }

    public Advertisement() {
    }

    public Advertisement(Renter renter, Apartment apartment, float price, boolean expired, boolean valid) {
        this.renter = renter;
        this.apartment = apartment;
        this.price = price;

        this.expired = expired;
        this.valid = valid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<RentRequest> getRentRequests() {
        return rentRequests;
    }

    public void setRentRequests(List<RentRequest> rentRequests) {
        this.rentRequests = rentRequests;
    }
}
