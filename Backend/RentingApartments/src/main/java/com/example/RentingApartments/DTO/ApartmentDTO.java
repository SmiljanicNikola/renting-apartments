package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.model.Renter;

import javax.persistence.*;

public class ApartmentDTO {

    private Integer id;

    private String address;

    private String city;

    private String apartmentName;

    private RenterDTO owner;

    private Integer numberOfRooms;

    private Integer numberOfBeds;

    private boolean petFriendly;

    public ApartmentDTO() {
    }

    public ApartmentDTO(Apartment apartment){
        this(apartment.getId(), apartment.getAddress(), apartment.getCity(), apartment.getApartmentName(), new RenterDTO(apartment.getOwner()), apartment.getNumberOfRooms(), apartment.getNumberOfBeds(), apartment.isPetFriendly());
    }

    public ApartmentDTO(String address, String city, String apartmentName, RenterDTO owner, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.address = address;
        this.city = city;
        this.apartmentName = apartmentName;
        this.owner = owner;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
    }

    public ApartmentDTO(Integer id, String address, String city, String apartmentName, RenterDTO owner, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.apartmentName = apartmentName;
        this.owner = owner;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
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

    public RenterDTO getOwner() {
        return owner;
    }

    public void setOwner(RenterDTO owner) {
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
}
