package com.example.RentingApartments.repository;

import com.example.RentingApartments.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
}
