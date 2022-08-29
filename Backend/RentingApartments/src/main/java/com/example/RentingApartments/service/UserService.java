package com.example.RentingApartments.service;

import com.example.RentingApartments.model.Client;
import com.example.RentingApartments.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Integer userId);

    User findByUsername(String username);


    User save(User user);

    void delete(Integer id);

    Page<User> findAll(Pageable pageable);

}
