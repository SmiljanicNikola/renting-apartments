package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.AddAdvertisementRequestDTO;
import com.example.RentingApartments.DTO.AddApartmentRequestDTO;
import com.example.RentingApartments.DTO.AdvertisementDTO;
import com.example.RentingApartments.DTO.ApartmentDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.service.AdvertisementService;
import com.example.RentingApartments.service.ApartmentService;
import com.example.RentingApartments.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private RenterService renterService;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisements(){
        List<AdvertisementDTO> advertisementsDTO = advertisementService
                .findAll()
                .stream()
                .map(a -> new AdvertisementDTO(a))
                .collect(Collectors.toList());

        return new ResponseEntity<>(advertisementsDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<AdvertisementDTO> getAdvertisementById(@PathVariable("id") Integer id){
        try
        {
            Advertisement advertisement = advertisementService.findById(id);
            return new ResponseEntity<>(new AdvertisementDTO(advertisement), HttpStatus.OK);
        }
        catch(ResourceNotFoundException resourceNotFoundException)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement with that id: "+ id ,resourceNotFoundException);
        }
    }

    @PostMapping()
    public ResponseEntity<AdvertisementDTO> saveAdvertisement(@RequestBody AddAdvertisementRequestDTO addAdvertisementRequestDTO) {

        Advertisement advertisement = new Advertisement();
        advertisement.setRenter(this.renterService.findById(addAdvertisementRequestDTO.getRenterId()));
        advertisement.setApartment(this.apartmentService.findById(addAdvertisementRequestDTO.getApartmentId()));
        advertisement.setPrice(addAdvertisementRequestDTO.getPrice());
        advertisement.setEmail(addAdvertisementRequestDTO.getEmail());
        advertisement.setExpired(false);
        advertisement.setValid(true);

        advertisement = advertisementService.save(advertisement);
        return new ResponseEntity<>(new AdvertisementDTO(advertisement), HttpStatus.CREATED);
    }

}
