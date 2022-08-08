package com.example.RentingApartments.DTO;

public class AddAdvertisementRequestDTO {

    private Integer id;

    private Integer renterId;

    private Integer apartmentId;

    private float price;

    private String email;

    private boolean expired;

    private boolean valid;

    public AddAdvertisementRequestDTO(Integer renterId, Integer apartmentId, float price, String email, boolean expired, boolean valid) {
        this.renterId = renterId;
        this.apartmentId = apartmentId;
        this.price = price;
        this.email = email;
        this.expired = expired;
        this.valid = valid;
    }

    public AddAdvertisementRequestDTO(Integer id, Integer renterId, Integer apartmentId, float price, String email, boolean expired, boolean valid) {
        this.id = id;
        this.renterId = renterId;
        this.apartmentId = apartmentId;
        this.price = price;
        this.email = email;
        this.expired = expired;
        this.valid = valid;
    }

    public AddAdvertisementRequestDTO(Integer renterId, Integer apartmentId, float price, String email, boolean expired) {
        this.renterId = renterId;
        this.apartmentId = apartmentId;
        this.price = price;
        this.email = email;
        this.expired = expired;
    }

    public AddAdvertisementRequestDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
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
