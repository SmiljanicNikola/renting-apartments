package com.example.RentingApartments.DTO;

import javax.persistence.Column;

public class SignUpRequestDTO {

    private String name;

    private String lastname;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    public SignUpRequestDTO() {
    }

    public SignUpRequestDTO(String name, String lastname, String username, String password, String phoneNumber, String email) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
