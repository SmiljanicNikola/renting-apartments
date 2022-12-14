package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.AddApartmentRequestDTO;
import com.example.RentingApartments.DTO.ApartmentDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.model.Renter;
import com.example.RentingApartments.service.ApartmentService;
import com.example.RentingApartments.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/apartments")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private RenterService renterService;

    @GetMapping
    public ResponseEntity<List<ApartmentDTO>> getApartments(){
        List<ApartmentDTO> apartmentsDTO = apartmentService
                .findAll()
                .stream()
                .map(a -> new ApartmentDTO(a))
                .collect(Collectors.toList());

        return new ResponseEntity<>(apartmentsDTO, HttpStatus.OK);
    }

    @GetMapping("/paginate")
    public ResponseEntity<Page<Apartment>> findAll(Pageable pageable){
        return new ResponseEntity<>(apartmentService.findAll(pageable), HttpStatus.OK);
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

    @PostMapping()
    public ResponseEntity<ApartmentDTO> saveApartment(@RequestBody AddApartmentRequestDTO addApartmentRequestDTO) {

        Apartment apartment = new Apartment();
        apartment.setAddress(addApartmentRequestDTO.getAddress());
        apartment.setCity(addApartmentRequestDTO.getCity());
        apartment.setApartmentName(addApartmentRequestDTO.getApartmentName());
        apartment.setOwner(this.renterService.findById(addApartmentRequestDTO.getOwnerId()));
        apartment.setNumberOfRooms(addApartmentRequestDTO.getNumberOfRooms());
        apartment.setNumberOfBeds(addApartmentRequestDTO.getNumberOfBeds());
        apartment.setPetFriendly(true);

        apartment = apartmentService.save(apartment);
        return new ResponseEntity<>(new ApartmentDTO(apartment), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ApartmentDTO> updateApartment(@RequestBody AddApartmentRequestDTO addApartmentRequestDTO, @PathVariable("id") Integer id) {

        Apartment apartment = apartmentService.findById(id);

        if (apartment == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(addApartmentRequestDTO.getAddress() != null) {
            apartment.setAddress(addApartmentRequestDTO.getAddress());
        }

        if(addApartmentRequestDTO.getCity() != null) {
            apartment.setCity(addApartmentRequestDTO.getCity());
        }

        if(addApartmentRequestDTO.getApartmentName() != null) {
            apartment.setApartmentName(addApartmentRequestDTO.getApartmentName());
        }

        if(addApartmentRequestDTO.getOwnerId() != null) {
            apartment.setOwner(this.renterService.findById(addApartmentRequestDTO.getOwnerId()));
        }

        if(addApartmentRequestDTO.getNumberOfRooms() != null) {
            apartment.setNumberOfRooms(addApartmentRequestDTO.getNumberOfRooms());
        }

        if(addApartmentRequestDTO.getNumberOfBeds() != null) {
            apartment.setNumberOfBeds(addApartmentRequestDTO.getNumberOfBeds());
        }

        apartment = apartmentService.save(apartment);

        return new ResponseEntity<>(new ApartmentDTO(apartment), HttpStatus.OK);

    }


}
