package com.example.RentingApartments.service.implementation;

import com.example.RentingApartments.model.Client;
import com.example.RentingApartments.repository.AdvertisementRepository;
import com.example.RentingApartments.repository.ClientRepository;
import com.example.RentingApartments.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Integer clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    @Override
    public Client save(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
       return clientRepository.findAll(pageable);
    }
}
