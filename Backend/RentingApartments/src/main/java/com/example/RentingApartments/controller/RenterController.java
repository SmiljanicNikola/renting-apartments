package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.AddApartmentRequestDTO;
import com.example.RentingApartments.DTO.AdvertisementDTO;
import com.example.RentingApartments.DTO.ApartmentDTO;
import com.example.RentingApartments.DTO.RenterDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.model.Renter;
import com.example.RentingApartments.service.AdvertisementService;
import com.example.RentingApartments.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/renters")
public class RenterController {

    @Autowired
    private RenterService renterService;

    @GetMapping
    public ResponseEntity<List<RenterDTO>> getRenters(){
        List<RenterDTO> rentersDTO = renterService
                .findAll()
                .stream()
                .map(renter -> new RenterDTO(renter))
                .collect(Collectors.toList());

        return new ResponseEntity<>(rentersDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<RenterDTO> getRenterById(@PathVariable("id") Integer id){
        try
        {
            Renter renter = renterService.findById(id);
            return new ResponseEntity<>(new RenterDTO(renter), HttpStatus.OK);
        }
        catch(ResourceNotFoundException resourceNotFoundException)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Renter with that id: "+ id ,resourceNotFoundException);
        }
    }


}
