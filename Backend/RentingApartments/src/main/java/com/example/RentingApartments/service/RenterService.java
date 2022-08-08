package com.example.RentingApartments.service;

import com.example.RentingApartments.model.Client;
import com.example.RentingApartments.model.Renter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RenterService {

    List<Renter> findAll();

    Renter findById(Integer renterId);

    Renter save(Renter renter);

    void delete(Integer id);

    Page<Renter> findAll(Pageable pageable);
}
