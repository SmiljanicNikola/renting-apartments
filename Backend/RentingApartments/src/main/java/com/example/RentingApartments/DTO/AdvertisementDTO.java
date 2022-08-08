package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.model.Renter;

import javax.persistence.*;

public class AdvertisementDTO {

    private Integer id;

    private RenterDTO renter;

    private ApartmentDTO apartment;

    private float price;

    private String email;

    private boolean expired;

    private boolean valid;

    public AdvertisementDTO(Advertisement advertisement){
        this(advertisement.getId(), new RenterDTO(advertisement.getRenter()), new ApartmentDTO(advertisement.getApartment()), advertisement.getPrice(), advertisement.getEmail(), advertisement.isExpired(), advertisement.isValid());
    }

    public AdvertisementDTO(RenterDTO renter, ApartmentDTO apartment, float price, String email, boolean expired, boolean valid) {
        this.renter = renter;
        this.apartment = apartment;
        this.price = price;
        this.email = email;
        this.expired = expired;
        this.valid = valid;
    }

    public AdvertisementDTO(Integer id, RenterDTO renter, ApartmentDTO apartment, float price, String email, boolean expired, boolean valid) {
        this.id = id;
        this.renter = renter;
        this.apartment = apartment;
        this.price = price;
        this.email = email;
        this.expired = expired;
        this.valid = valid;
    }

    public AdvertisementDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RenterDTO getRenter() {
        return renter;
    }

    public void setRenter(RenterDTO renter) {
        this.renter = renter;
    }

    public ApartmentDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentDTO apartment) {
        this.apartment = apartment;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
