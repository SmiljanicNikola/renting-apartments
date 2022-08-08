package com.example.RentingApartments.repository;

import com.example.RentingApartments.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
}
