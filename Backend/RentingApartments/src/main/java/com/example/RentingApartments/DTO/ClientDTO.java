package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Client;
import com.example.RentingApartments.model.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class ClientDTO {

    private Integer id;

    private UserDTO user;

    private String phoneNumber;

    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Client client){
        this(client.getId(), new UserDTO(client.getUser()), client.getPhoneNumber(), client.getEmail());
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

    public ClientDTO(UserDTO user, String phoneNumber, String email) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ClientDTO(Integer id, UserDTO user, String phoneNumber, String email) {
        this.id = id;
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
