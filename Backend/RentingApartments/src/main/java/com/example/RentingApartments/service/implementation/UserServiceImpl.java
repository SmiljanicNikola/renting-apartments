package com.example.RentingApartments.service.implementation;

import com.example.RentingApartments.model.User;
import com.example.RentingApartments.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
}
