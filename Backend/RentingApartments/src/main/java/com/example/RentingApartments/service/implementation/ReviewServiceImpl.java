package com.example.RentingApartments.service.implementation;

import com.example.RentingApartments.model.Review;
import com.example.RentingApartments.repository.ApartmentRepository;
import com.example.RentingApartments.repository.ReviewRepository;
import com.example.RentingApartments.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Integer reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public Review save(Review review) {
        reviewRepository.save(review);
        return review;
    }

    @Override
    public void delete(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }
}
