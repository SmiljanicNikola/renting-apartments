package com.example.RentingApartments.service.implementation;

import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.repository.AdvertisementRepository;
import com.example.RentingApartments.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement findById(Integer advertisementId) {
        return advertisementRepository.findById(advertisementId).orElse(null);
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
        return advertisement;
    }

    @Override
    public void delete(Integer id) {
        advertisementRepository.deleteById(id);
    }

    @Override
    public Page<Advertisement> findAll(Pageable pageable) {
        return advertisementRepository.findAll(pageable);
    }
}
