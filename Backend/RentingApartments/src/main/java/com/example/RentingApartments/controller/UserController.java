package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.RenterDTO;
import com.example.RentingApartments.DTO.UserDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Renter;
import com.example.RentingApartments.model.User;
import com.example.RentingApartments.service.RenterService;
import com.example.RentingApartments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> usersDTO = userService
                .findAll()
                .stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());

        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id){
        try
        {
            User user = userService.findById(id);
            return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
        }
        catch(ResourceNotFoundException resourceNotFoundException)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with that id: "+ id ,resourceNotFoundException);
        }
    }

}
