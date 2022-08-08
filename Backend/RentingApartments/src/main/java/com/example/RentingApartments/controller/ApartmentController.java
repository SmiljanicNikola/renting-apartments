package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.ApartmentDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.service.ApartmentService;
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
@RequestMapping(value = "api/apartments")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public ResponseEntity<List<ApartmentDTO>> getApartments(){
        List<ApartmentDTO> apartmentsDTO = apartmentService
                .findAll()
                .stream()
                .map(a -> new ApartmentDTO(a))
                .collect(Collectors.toList());

        return new ResponseEntity<>(apartmentsDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ApartmentDTO> getApartmentById(@PathVariable("id") Integer id){
        try
        {
            Apartment apartment = apartmentService.findById(id);
            return new ResponseEntity<>(new ApartmentDTO(apartment), HttpStatus.OK);
        }
        catch(ResourceNotFoundException resourceNotFoundException)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment with that id: "+ id ,resourceNotFoundException);
        }
    }
}
