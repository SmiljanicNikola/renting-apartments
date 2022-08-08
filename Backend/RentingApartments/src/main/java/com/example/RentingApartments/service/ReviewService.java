package com.example.RentingApartments.service;

import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    Review findById(Integer reviewId);

    Review save(Review review);

    void delete(Integer id);

    Page<Review> findAll(Pageable pageable);

}
