package com.example.RentingApartments.service.implementation;

import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.repository.ApartmentRepository;
import com.example.RentingApartments.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public List<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    @Override
    public Apartment findById(Integer apartmentId) {
        return apartmentRepository.findById(apartmentId).orElse(null);
    }

    @Override
    public Apartment save(Apartment apartment) {
        apartmentRepository.save(apartment);
        return apartment;
    }

    @Override
    public void delete(Integer id) {
        apartmentRepository.deleteById(id);
    }

    @Override
    public Page<Apartment> findAll(Pageable pageable) {
        return apartmentRepository.findAll(pageable);
    }
}
