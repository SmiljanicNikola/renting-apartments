package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Renter;
import com.example.RentingApartments.model.User;


public class RenterDTO {

    private Integer id;

    private UserDTO user;

    private String phoneNumber;

    private String email;

    public RenterDTO() {
    }

    public RenterDTO(Renter renter){
        this(renter.getId(), new UserDTO(renter.getUser()), renter.getPhoneNumber(), renter.getEmail());
    }

    public RenterDTO(Integer id, UserDTO user, String phoneNumber, String email) {
        this.id = id;
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public RenterDTO(UserDTO user, String phoneNumber, String email) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
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
