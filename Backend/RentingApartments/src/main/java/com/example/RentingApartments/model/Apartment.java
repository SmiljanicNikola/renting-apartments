package com.example.RentingApartments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="apartment_id", unique = true, nullable = false)
    private Integer id;

    @Column(name="address", unique=false, nullable=false)
    private String address;

    @Column(name="city", unique=false, nullable=false)
    private String city;

    @Column(name="apartment_name", unique=false, nullable=false)
    private String apartmentName;

    @ManyToOne
    @JoinColumn(name="renter_id", referencedColumnName = "renter_id")
    private Renter owner;

    @Column(name="number_of_rooms", unique=false, nullable=false)
    private Integer numberOfRooms;

    @Column(name="number_of_beds", unique=false, nullable=false)
    private Integer numberOfBeds;

    @Column(name="pet_friendly", unique=false, nullable=false)
    private boolean petFriendly;

    @JsonIgnore
    @OneToMany(mappedBy="apartment")
    private List<Advertisement> advertisements;

    @JsonIgnore
    @OneToMany(mappedBy="apartment")
    private List<Review> reviews;

    public Apartment(Integer id, String address, String city, Renter owner, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.owner = owner;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
    }

    public Apartment(Integer id, String address, String city, String apartmentName, Renter owner, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.apartmentName = apartmentName;
        this.owner = owner;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
    }

    public Apartment(String address, String city, String apartmentName, Renter owner, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.address = address;
        this.city = city;
        this.apartmentName = apartmentName;
        this.owner = owner;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
    }

    public Apartment(String address, String city, Renter owner, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.address = address;
        this.city = city;
        this.owner = owner;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
    }

    public Apartment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Renter getOwner() {
        return owner;
    }

    public void setOwner(Renter owner) {
        this.owner = owner;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }
}
