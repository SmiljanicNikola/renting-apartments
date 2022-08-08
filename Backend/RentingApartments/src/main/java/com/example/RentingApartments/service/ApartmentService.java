package com.example.RentingApartments.service;

import com.example.RentingApartments.model.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ApartmentService {

    List<Apartment> findAll();

    Apartment findById(Integer apartmentId);

    Apartment save(Apartment apartment);

    void delete(Integer id);

    Page<Apartment> findAll(Pageable pageable);


}
