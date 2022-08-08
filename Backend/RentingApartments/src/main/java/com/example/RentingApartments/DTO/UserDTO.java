package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Roles;
import com.example.RentingApartments.model.User;

public class UserDTO {

    private Integer id;

    private String name;

    private String lastname;

    private String username;

    private String password;

    private Roles role;

    public UserDTO() {
    }

    public UserDTO(String name, String lastname, String username, String password, Roles role) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDTO(Integer id, String name, String lastname, String username, String password, Roles role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getLastname(), user.getUsername(), user.getPassword(), user.getRole());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
