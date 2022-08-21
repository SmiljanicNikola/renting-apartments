package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.AddReviewRequestDTO;
import com.example.RentingApartments.DTO.RentRequestDTO;
import com.example.RentingApartments.DTO.RentRequestFormDTO;
import com.example.RentingApartments.DTO.ReviewDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.RentRequest;
import com.example.RentingApartments.model.Review;
import com.example.RentingApartments.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/rentRequests")
public class RentRequestController {

    @Autowired
    private RentRequestService rentRequestService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public ResponseEntity<List<RentRequestDTO>> getRentRequests(){
        List<RentRequestDTO> rentRequestsDTO = rentRequestService
                .findAll()
                .stream()
                .map(rentRequest -> new RentRequestDTO(rentRequest))
                .collect(Collectors.toList());

        return new ResponseEntity<>(rentRequestsDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<RentRequestDTO> getRentRequestById(@PathVariable("id") Integer id){
        try
        {
            RentRequest rentRequest = rentRequestService.findById(id);
            return new ResponseEntity<>(new RentRequestDTO(rentRequest), HttpStatus.OK);
        }
        catch(ResourceNotFoundException resourceNotFoundException)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rent Request with that id: "+ id ,resourceNotFoundException);
        }
    }

    @PostMapping()
    public ResponseEntity<RentRequestDTO> saveRentRequest(@RequestBody RentRequestFormDTO rentRequestFormDTO) {

        RentRequest rentRequest = new RentRequest();
        rentRequest.setClient(this.clientService.findById(rentRequestFormDTO.getClientId()));
        rentRequest.setAdvertisement(this.advertisementService.findById(rentRequestFormDTO.getAdvertisementId()));
        rentRequest.setStartDate(rentRequestFormDTO.getStartDate());
        rentRequest.setEndDate(rentRequestFormDTO.getEndDate());
        rentRequest.setAdditionalMessage(rentRequestFormDTO.getAdditionalMessage());

        rentRequest = rentRequestService.save(rentRequest);
        return new ResponseEntity<>(new RentRequestDTO(rentRequest), HttpStatus.CREATED);
    }
}
