package com.example.RentingApartments.service;

import com.example.RentingApartments.model.RentRequest;
import com.example.RentingApartments.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RentRequestService {

    List<RentRequest> findAll();

    RentRequest findById(Integer rentRequestId);

    RentRequest save(RentRequest rentRequest);

    void delete(Integer id);

    Page<RentRequest> findAll(Pageable pageable);
}
