package com.example.RentingApartments.service;

import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.model.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAll();

    Advertisement findById(Integer advertisementId);

    Advertisement save(Advertisement advertisement);

    void delete(Integer id);

    Page<Advertisement> findAll(Pageable pageable);
}
