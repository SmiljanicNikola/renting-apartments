package com.example.RentingApartments.repository;

import com.example.RentingApartments.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USERS  where users.username = :username", nativeQuery = true)
    User findUserByUsername(String username);

}
