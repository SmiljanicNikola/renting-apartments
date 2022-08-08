package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.ClientDTO;
import com.example.RentingApartments.DTO.RentRequestDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Client;
import com.example.RentingApartments.model.RentRequest;
import com.example.RentingApartments.service.ClientService;
import com.example.RentingApartments.service.RentRequestService;
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
@RequestMapping(value = "api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients(){
        List<ClientDTO> clientsDTO = clientService
                .findAll()
                .stream()
                .map(client -> new ClientDTO(client))
                .collect(Collectors.toList());

        return new ResponseEntity<>(clientsDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Integer id){
        try
        {
            Client client = clientService.findById(id);
            return new ResponseEntity<>(new ClientDTO(client), HttpStatus.OK);
        }
        catch(ResourceNotFoundException resourceNotFoundException)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client with that id: "+ id ,resourceNotFoundException);
        }
    }
}
