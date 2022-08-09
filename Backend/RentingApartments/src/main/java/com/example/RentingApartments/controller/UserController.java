package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.RenterDTO;
import com.example.RentingApartments.DTO.SignUpRequestDTO;
import com.example.RentingApartments.DTO.UserDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Client;
import com.example.RentingApartments.model.Renter;
import com.example.RentingApartments.model.Roles;
import com.example.RentingApartments.model.User;
import com.example.RentingApartments.service.ClientService;
import com.example.RentingApartments.service.RenterService;
import com.example.RentingApartments.service.UserService;
import com.mysql.cj.protocol.ExportControlled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RenterService renterService;

    @Autowired
    private ClientService clientService;

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

    @PostMapping("/renter")
    public ResponseEntity<?> registerRenter(@RequestBody SignUpRequestDTO signUpRequest){
        User user = new User(signUpRequest.getName(), signUpRequest.getLastname(), signUpRequest.getUsername(), signUpRequest.getPassword());
        user.setRole(Roles.RENTER);

        userService.save(user);

        Renter renter = new Renter(user, signUpRequest.getPhoneNumber(), signUpRequest.getEmail());
        renterService.save(renter);

        return ResponseEntity.ok("Renter Successfuly registered!");
    }

    @PostMapping("/client")
    public ResponseEntity<?> registerClient(@RequestBody SignUpRequestDTO signUpRequest){
        User user = new User(signUpRequest.getName(), signUpRequest.getLastname(), signUpRequest.getUsername(), signUpRequest.getPassword());
        user.setRole(Roles.CLIENT);

        userService.save(user);

        Client client = new Client(user, signUpRequest.getPhoneNumber(), signUpRequest.getEmail());
        clientService.save(client);

        return ResponseEntity.ok("Client Successfuly registered!");
    }

}
