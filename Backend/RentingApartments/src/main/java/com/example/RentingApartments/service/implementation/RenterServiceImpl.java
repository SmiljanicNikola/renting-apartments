package com.example.RentingApartments.service.implementation;

import com.example.RentingApartments.model.Renter;
import com.example.RentingApartments.repository.ClientRepository;
import com.example.RentingApartments.repository.RenterRepository;
import com.example.RentingApartments.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterServiceImpl implements RenterService {

    @Autowired
    private RenterRepository renterRepository;

    @Override
    public List<Renter> findAll() {
       return renterRepository.findAll();
    }

    @Override
    public Renter findById(Integer renterId) {
        return renterRepository.findById(renterId).orElse(null);
    }

    @Override
    public Renter save(Renter renter) {
        renterRepository.save(renter);
        return renter;
    }

    @Override
    public void delete(Integer id) {
        renterRepository.deleteById(id);
    }

    @Override
    public Page<Renter> findAll(Pageable pageable) {
        return renterRepository.findAll(pageable);
    }
}
