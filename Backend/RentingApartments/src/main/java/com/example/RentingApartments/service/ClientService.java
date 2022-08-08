package com.example.RentingApartments.service;

import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client findById(Integer clientId);

    Client save(Client client);

    void delete(Integer id);

    Page<Client> findAll(Pageable pageable);
}
