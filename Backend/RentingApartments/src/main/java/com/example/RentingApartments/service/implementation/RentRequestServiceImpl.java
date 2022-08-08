package com.example.RentingApartments.service.implementation;

import com.example.RentingApartments.model.RentRequest;
import com.example.RentingApartments.repository.RentRequestRepository;
import com.example.RentingApartments.repository.RenterRepository;
import com.example.RentingApartments.service.RentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentRequestServiceImpl implements RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Override
    public List<RentRequest> findAll() {
        return rentRequestRepository.findAll();
    }

    @Override
    public RentRequest findById(Integer rentRequestId) {
        return rentRequestRepository.findById(rentRequestId).orElse(null);
    }

    @Override
    public RentRequest save(RentRequest rentRequest) {
        rentRequestRepository.save(rentRequest);
        return rentRequest;
    }

    @Override
    public void delete(Integer id) {
        rentRequestRepository.deleteById(id);
    }

    @Override
    public Page<RentRequest> findAll(Pageable pageable) {
        return null;
    }
}
