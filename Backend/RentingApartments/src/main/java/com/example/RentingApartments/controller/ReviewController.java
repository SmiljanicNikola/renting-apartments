package com.example.RentingApartments.controller;

import com.example.RentingApartments.DTO.*;
import com.example.RentingApartments.exceptions.ResourceNotFoundException;
import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.model.Review;
import com.example.RentingApartments.model.User;
import com.example.RentingApartments.service.ApartmentService;
import com.example.RentingApartments.service.ClientService;
import com.example.RentingApartments.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private ClientService clientService;

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

    @PostMapping()
    public ResponseEntity<ReviewDTO> saveReview(@RequestBody AddReviewRequestDTO addReviewRequestDTO) {

        Review review = new Review();
        review.setApartment(this.apartmentService.findById(addReviewRequestDTO.getApartmentId()));
        review.setReviewAuthor(this.clientService.findById(addReviewRequestDTO.getReviewAuthorId()));
        review.setGrade(addReviewRequestDTO.getGrade());
        review.setComment(addReviewRequestDTO.getComment());

        review = reviewService.save(review);
        return new ResponseEntity<>(new ReviewDTO(review), HttpStatus.CREATED);
    }

}
