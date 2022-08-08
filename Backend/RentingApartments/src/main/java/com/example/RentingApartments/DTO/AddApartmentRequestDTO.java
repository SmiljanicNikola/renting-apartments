package com.example.RentingApartments.DTO;

public class AddApartmentRequestDTO {

    private Integer id;

    private String address;

    private String city;

    private Integer ownerId;

    private Integer numberOfRooms;

    private Integer numberOfBeds;

    private boolean petFriendly;

    public AddApartmentRequestDTO() {
    }

    public AddApartmentRequestDTO(Integer id, String address, String city, Integer ownerId, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.ownerId = ownerId;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
    }

    public AddApartmentRequestDTO(String address, String city, Integer ownerId, Integer numberOfRooms, Integer numberOfBeds, boolean petFriendly) {
        this.address = address;
        this.city = city;
        this.ownerId = ownerId;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petFriendly;
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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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
