package com.example.RentingApartments.repository;

import com.example.RentingApartments.model.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Integer> {
}
