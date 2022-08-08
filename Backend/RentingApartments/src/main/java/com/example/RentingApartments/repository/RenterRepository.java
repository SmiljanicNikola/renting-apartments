package com.example.RentingApartments.repository;

import com.example.RentingApartments.model.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Integer> {

}
