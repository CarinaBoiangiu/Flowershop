package com.details.FlowerShop.service;

import com.details.FlowerShop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> findByID(Long id);
    List<User> findAll();
    User update(User user);
    void deleteById(Long id);
    Optional<User>  findByUserName(String userName);
}
