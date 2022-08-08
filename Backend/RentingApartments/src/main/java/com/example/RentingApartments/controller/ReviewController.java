package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.ReviewDTO;
import com.example.RentingApartments.DTO.UserDTO;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Review;
import com.example.RentingApartments.model.User;
import com.example.RentingApartments.service.ReviewService;
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
@RequestMapping(value = "api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getReviews(){
        List<ReviewDTO> reviewsDTO = reviewService
                .findAll()
                .stream()
                .map(review -> new ReviewDTO(review))
                .collect(Collectors.toList());

        return new ResponseEntity<>(reviewsDTO, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable("id") Integer id){
        try
        {
            Review review = reviewService.findById(id);
            return new ResponseEntity<>(new ReviewDTO(review), HttpStatus.OK);
        }
        catch(ResourceNotFoundException resourceNotFoundException)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review with that id: "+ id ,resourceNotFoundException);
        }
    }

}
